package com.gqb.order.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gqb.common.utils.R;
import com.gqb.order.client.StockClient;
import com.gqb.order.client.UserFeign;
import com.gqb.order.dao.OrderDao;
import com.gqb.order.dao.OrderReturnDao;
import com.gqb.order.entity.Order;
import com.gqb.order.entity.OrderReturn;
import com.gqb.order.entity.vo.ConfirmResponseVo;
import com.gqb.order.entity.vo.ConfirmVo;
import com.gqb.order.entity.vo.OrderVo;
import com.gqb.order.entity.vo.TicketLockVo;
import com.gqb.order.service.OrderService;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author GanQingbo
 * @Classname OrderServiceImpl
 * @Description
 * @date 2021/3/15 9:52
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StockClient stockClient;

    @Resource
    private OrderReturnDao returnDao;

    @Resource
    private UserFeign userFeign;

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private ThreadLocal<ConfirmVo> confirmVoThreadLocal=new ThreadLocal<>();
    private ThreadLocal<Order> orderThreadLocal=new ThreadLocal<>();

    /**
     * 发送创建请求到mq
     *
     * @param order
     * @return
     */
    @Override
    public int sendCreateRequest(Order order) {
        return 0;
    }

    /**
     * 一般方法创建订单-减库存
     *
     * @param order
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int createOrder(Order order) {

        int i = orderDao.createOrder(order);
        if (i > 0) {
            //创建订单成功，开始减库存
            R r = stockClient.sellTicket(order.getTicketId());
            //更新订单信息
            BigDecimal price = stockClient.getPriceById(order.getTicketId());
            order.setSeatNo((int) r.getData().get("seat_no"));
            order.setOrderAmount(price);
            orderDao.updateSeatAndAmount(order);
            //返回座位号
            return (int) r.getData().get("seat_no");
        }
        return -1;
    }

    /**
     * 直接发请求下订单
     *
     * @param order
     * @return
     */
    @Override
    public int secKill(Order order) {
        //建立redis连接
        Jedis jedis = new Jedis("159.75.112.187", 6379);
        jedis.auth("123456");
        //拼接key，一个库存的key(string类型)，一个成功的用户的key(放进一个set里)
        String stockKey = "SecKill:" + "stock:" + order.getTicketId();
        String userKey = "SecKill:" + "user:" + order.getTicketId();
        //超卖问题，开始监视库存
        jedis.watch(stockKey);
        //获取库存
        String stock = jedis.get(stockKey);
        //1.还未开始，库存为null
        if (stock == null) {
            log.info("Order=====>售票还未开始");
            jedis.close();
            return -1;
        }
        //2.已经购买成功，set中已经有该userId
        String userId = String.valueOf(order.getUserId());
        if (jedis.sismember(userKey, userId)) {
            log.info("Order=====>不能重复购买");
            jedis.close();
            return -2;
        }
        //3.判断库存是否大于0
        if (Integer.parseInt(stock) <= 0) {
            log.info("Order=====>票已经卖完啦");
            jedis.close();
            return -3;
        }
        //4.成功售票
        Transaction transaction = jedis.multi(); //开启了事务
        transaction.decr(stockKey); //自减
        //transaction.sadd(userKey,userId); //添加用户id到已购买set
        List<Object> exec = transaction.exec(); //开始事务
        if (exec == null || exec.size() == 0) {
            log.info("Order=====>出票失败了");
            jedis.close();
            return -2;
        }
        log.info("Order=====>成功出票");
        log.info("Order=====>用户id：" + userId);

        //开始创建订单,完善订单信息
        order.setOrderAmount(stockClient.getPriceById(order.getTicketId()));
        System.out.println("订单金额：" + order.getOrderAmount());
        int i = orderDao.createOrder(order);
        if (i > 0) {
            //订单创建成功，发送一条新消息更新库存表
            log.info("Order=====>创建订单成功");
            jedis.close();
            Long ticketId = order.getTicketId();
            rabbitTemplate.convertAndSend("weshow-perfectOrder", "stock.update", ticketId, new CorrelationData(UUID.randomUUID().toString()));
            //rabbitTemplate.convertAndSend("weshow-perfectOrder","payment.update",order,new CorrelationData(UUID.randomUUID().toString()));
            return 1;
        } else {
            Transaction inTrans = jedis.multi(); //开启了事务
            inTrans.incr(stockKey); //库存还原
            //inTrans.srem(userKey,userId); //添加用户id到已购买set
            List<Object> list = inTrans.exec(); //开始事务
            if (list == null || list.size() == 0) {
                log.info("Order=====>还库失败了");
                jedis.close();
                return -3;
            }
        }
        return 0;
    }

    /**
     * 加入redis,从mq收到消息来创建订单
     *
     * @param order
     * @return
     */
    @Override
    //@RabbitListener(queues = {"order-create-queue"})
    public void secKillByMessage(Message message, Order order, Channel channel) {
        //接收消息
        byte[] body = message.getBody();
        log.info("Order=====>收到创建订单的消息");
        //channel内自增的tag
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            //建立redis连接
            Jedis jedis = new Jedis("159.75.112.187", 6379);
            jedis.auth("123456");
            //拼接key，一个库存的key(string类型)，一个成功的用户的key(放进一个set里)
            String stockKey = "SecKill:" + "stock:" + order.getTicketId();
            String userKey = "SecKill:" + "user:" + order.getTicketId();
            //超卖问题，开始监视库存
            jedis.watch(stockKey);
            //获取库存
            String stock = jedis.get(stockKey);
            //1.还未开始，库存为null
            if (stock == null) {
                log.info("Order=====>售票还未开始");
                jedis.close();
                return;
            }
            //2.已经购买成功，set中已经有该userId
            String userId = String.valueOf(order.getUserId());
            if (jedis.sismember(userKey, userId)) {
                log.info("Order=====>不能重复购买");
                jedis.close();
                return;
            }
            //3.判断库存是否大于0
            if (Integer.parseInt(stock) <= 0) {
                log.info("Order=====>票已经卖完啦");
                jedis.close();
                return;
            }
            //4.成功售票
            Transaction transaction = jedis.multi(); //开启了事务
            transaction.decr(stockKey); //自减
            //transaction.sadd(userKey,userId); //添加用户id到已购买set
            List<Object> exec = transaction.exec(); //开始事务
            if (exec == null || exec.size() == 0) {
                log.info("Order=====>出票失败了");
                jedis.close();
                return;
            }
            log.info("Order=====>成功出票");
            log.info("Order=====>用户id：" + userId);

            //开始创建订单,完善订单信息
            order.setOrderAmount(stockClient.getPriceById(order.getTicketId()));
            System.out.println("订单金额：" + order.getOrderAmount());
            int i = orderDao.createOrder(order);
            if (i > 0) {
                //订单创建成功，确认消息，发送一条新消息更新库存表
                channel.basicAck(deliveryTag, false);
                log.info("Order=====>创建订单成功");
                jedis.close();
                Long ticketId = order.getTicketId();
                rabbitTemplate.convertAndSend("weshow-perfectOrder", "stock.update", ticketId, new CorrelationData(UUID.randomUUID().toString()));
                //rabbitTemplate.convertAndSend("weshow-perfectOrder","payment.update",order,new CorrelationData(UUID.randomUUID().toString()));
                //R r = stockClient.sellTicket(order.getTicketId());
            } else {
                //消息不重新入队
                channel.basicNack(deliveryTag, false, false);
                Transaction inTrans = jedis.multi(); //开启了事务
                transaction.incr(stockKey); //库存还原
                //transaction.srem(userKey,userId); //添加用户id到已购买set
                List<Object> list = inTrans.exec(); //开始事务
                if (list == null || list.size() == 0) {
                    log.info("Order=====>还库失败了");
                    jedis.close();
                    return;
                }
            }
            return;
        } catch (IOException e) {
            //网络异常
            e.printStackTrace();
        }
    }

    @Override
    public int updateTicket(Order order) {
        int i = orderDao.updateSeatAndAmount(order);
        return i;
    }

    /**
     * 带查询结果的分页
     *
     * @param page
     * @param size
     * @param order
     * @return
     */
    @Override
    public PageInfo<Order> getOrderByPage(Integer page, Integer size, Order order) {
        //开启分页
        PageHelper.startPage(page, size);
        System.out.println(order.getDeleteStatus());
        List<Order> query = orderDao.getOrderQuery(order);
        //封装到PageInfo
        PageInfo<Order> pageInfo = new PageInfo<>(query);
        return pageInfo;
    }

    @Override
    public Order getOrderById(Long id) {
        Order orderById = orderDao.getOrderById(id);
        return orderById;
    }

    @Override
    public int updateOrder(Order order) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        order.setUpdateTime(date);
        int i = orderDao.updateOrder(order);
        return i;
    }

    /**
     * 物理删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteOrder(Long id) {
        int i = orderDao.deleteOrder(id);
        return i;
    }

    /**
     * 逻辑删除，删除状态改变
     *
     * @param id
     * @return
     */
    @Override
    public int updateOrderDeleteStatus(Long id) {
        Order order = orderDao.getOrderById(id);
        if (order.getDeleteStatus() == 0) {
            order.setDeleteStatus((byte) 1);
        } else {
            order.setDeleteStatus((byte) 0);
        }
        int i = orderDao.updateOrderDeleteStatus(order);
        return i;
    }

    /**
     * 退票相关，创建一个退票申请
     *
     * @param id
     * @return
     */
    @Override
    public int createOrderReturn(Long id) {
        //订单id
        int orderReturn1 = returnDao.createOrderReturn(id);
        //修改订单状态
        Order order = new Order();
        order.setId(id);
        order.setOrderStatus((byte)2);
        orderDao.setOrderStatus(order);
        return orderReturn1;
    }

    /**
     * 管理员处理退票，库存更新
     * @param orderReturn
     * @return
     */
    @Override
    public int updateOrderReturn(OrderReturn orderReturn) {
        orderReturn.setAdminId(1001L);
        orderReturn.setHandleTime(new Date());
        Order order = orderDao.getOrderById(orderReturn.getOrderId());
        if (order != null) {
            orderReturn.setReturnMoney(order.getOrderAmount());
        }
        //更新订单状态
        order.setOrderStatus((byte)3);
        orderDao.setOrderStatus(order);
        int i = returnDao.updateOrderReturn(orderReturn);
        if(i>0){
            //还库存,计算票数num=amount / ticket-id-seat_price
            BigDecimal price = stockClient.getPriceById(order.getTicketId());
            BigDecimal amount = order.getOrderAmount();
            int num=amount.intValue()/price.intValue();
            log.info("=====远程调用归还库存");
            TicketLockVo ticket=new TicketLockVo();
            ticket.setId(order.getTicketId());
            ticket.setNumber(num);
            stockClient.ticketReturn(ticket);
        }
        //从售票记录中移除，order_id->show_id and user_id->number
        R r = userFeign.returnTicket(order);
        if(r.getSuccess()){
            log.info("=====远程删除售票记录成功");
        }
        return i;
    }

    /**
     * 带分页的查询结果
     *
     * @param page
     * @param size
     * @param orderReturn
     * @return
     */
    @Override
    public PageInfo<OrderReturn> getOrderReturnQuery(Integer page, Integer size, OrderReturn orderReturn) {
        PageHelper.startPage(page, size);
        List<OrderReturn> orderReturnQuery = returnDao.getOrderReturnQuery(orderReturn);
        PageInfo<OrderReturn> pageInfo = new PageInfo<>(orderReturnQuery);
        return pageInfo;
    }

    /**
     * 订单确认,创建订单-验令牌-锁库存
     */
    @Transactional
    @Override
    public ConfirmResponseVo orderConfirm(ConfirmVo confirmVo) {
        ConfirmResponseVo responseVo = new ConfirmResponseVo();
        //ThreadLocal共享数据
        confirmVoThreadLocal.set(confirmVo);
        //1.验令牌
        String orderToken = confirmVo.getToken();
        String redisToken = stringRedisTemplate.opsForValue().get("Order:Token:" + confirmVo.getUserId());
        log.info("=====RedisToken:" + redisToken);
        //lua,存在表示是第一次操作，执行业务并把token删除，不存在返回0
        String script = "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
       /* if(orderToken!=null && orderToken.equals(redisToken)){
            //验证通过

        }else {
            //验证失败
        }*/
        Long result = stringRedisTemplate.execute(new DefaultRedisScript<Long>(script, Long.class), Arrays.asList("Order:Token:" + confirmVo.getUserId()), orderToken);
        if (result == 0L) {
            log.info("=====OrderToken验证失败");
            responseVo.setCode(1);
            return responseVo;
        } else {
            log.info("=====OrderToken验证成功,生成订单中...");
            //2.创建订单
            long i = createOrderByConfirm();
            if(i>0){
                log.info("=====订单生成成功，远程调用锁定库存");
                TicketLockVo ticketLockVo=new TicketLockVo();
                ticketLockVo.setId(confirmVo.getTicketId());
                ticketLockVo.setNumber(confirmVo.getNumber()); //锁的数量
                Order order = orderThreadLocal.get();
                ticketLockVo.setOrderId(order.getId()); //锁的订单id
                //3.远程调用锁库存，消息队列自动解锁
                R r = stockClient.ticketLocked(ticketLockVo);
                if(r.getSuccess()==true){
                    //状态码为0是成功
                    responseVo.setCode(0);
                    responseVo.setOrder(orderThreadLocal.get());
                    return responseVo;
                }else {
                    //锁库存失败
                    responseVo.setCode(2);
                    return responseVo;
                }
            }
            //订单创建失败
            responseVo.setCode(3);
            return responseVo;
        }
    }

    /**
     * 创建订单
     * @return
     */
    @Transactional
    public Long createOrderByConfirm(){
        ConfirmVo confirmVo=confirmVoThreadLocal.get();
        Order order = new Order();
        //snowflake生成唯一订单号
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        Long orderSn = snowflake.nextId();
        order.setOrderSn(orderSn.toString());
        log.info("=====订单号：" + orderSn);
        order.setUserId(confirmVo.getUserId());
        //获取演出id
        R showIdByTicketId = stockClient.getShowIdByTicketId(confirmVo.getTicketId());
        Object showId = showIdByTicketId.getData().get("showId");
        Long longShowId=Long.valueOf(showId.toString());
        log.info("=====演出Id：" + longShowId);
        order.setShowId(longShowId);
        log.info("=====售票Id：" + confirmVo.getTicketId());
        order.setTicketId(confirmVo.getTicketId());
        order.setOrderAmount(confirmVo.getAmount());
        int isSuccess = orderDao.createOrder(order);
        log.info("=====新创建的订单Id："+order.getId());
        if(isSuccess>0){
            orderThreadLocal.set(order);
            return orderSn;
        }
        return 0L;
    }

    /**
     * 获取订单唯一token，30分钟超时
     *
     * @param userId
     * @return
     */
    @Override
    public String getOrderToken(Long userId) {
        String token = UUID.randomUUID().toString().replace("-", "");
        stringRedisTemplate.opsForValue().set("Order:Token:" + userId, token, 30, TimeUnit.MINUTES);
        return token;
    }

    /**
     * 订单支付成功，修改订单-库存解锁
     * @param
     * @return
     */
    @Transactional
    @Override
    public int orderPaySuccess(TicketLockVo ticketLockVo) {
        Order order=new Order();
        order.setId(ticketLockVo.getOrderId());
        //更新订单支付状态===怎么判断支付成功呢？支付宝要公网网址才可以跳转成功
        order.setOrderStatus((byte)1);
        //支付时间
        Date date=new Date();
        Timestamp paymentTime=new Timestamp(date.getTime());
        order.setPaymentTime(paymentTime);
        order.setPaymentType((byte)1);

        int i = orderDao.updateOrder(order);
        //生成购买记录（待开发）
        //扣库存
        R r = stockClient.ticketUnlocking(ticketLockVo);
        if(i==0){
            log.info("=====订单状态更新失败，OrderId："+order.getId());
            return 1;
        }
        if(r.getSuccess()==false){
            log.info("=====远程扣减库存失败");
            return 2;
        }
        if(i>0 && r.getSuccess()==true){
            log.info("=====订单状态更新成功");
            return 0;
        }
        return -1;
    }


    /**
     * 根据用户id获取订单信息
     * @param id
     * @return
     */
    @Override
    public List<Order> getOrderByUserId(Long id) {
        List<Order> orderByUserId = orderDao.getOrderByUserId(id);
        return orderByUserId;
    }

    /**
     * 根据用户id获取完整的订单信息
     * @param id
     * @return
     */
    @Override
    public List<OrderVo> getOrderVoByUserId(Long id) {
        List<OrderVo> orderVoByUserId = orderDao.getOrderVoByUserId(id);
        log.info("=====订单查询成功");
        for(OrderVo orderVo:orderVoByUserId){
            log.info("=====订单sn："+orderVo.getOrderSn());
            Date date=new Date();
            if(orderVo.getShowTime().getTime()> date.getTime()){
                //0未上映,1已上映
                orderVo.setShowStatus((byte)0);
                log.info("=====订单演出未上映");
            }else {
                orderVo.setShowStatus((byte)1);
            }
            //订单状态,0待支付，1已支付，2退票中，3退票完成
        }
        return orderVoByUserId;
    }

    /**
     * 根据用户id获取演出id列表
     * @param id
     * @return
     */
    @Override
    public List<Long> getShowsByUser(Long id) {
        List<Long> showsId=new ArrayList<>();
        List<Order> orders = getOrderByUserId(id);
        for(Order order:orders){
            //遍历order取出showId
            showsId.add(order.getShowId());
        }
        return showsId;
    }

    /**
     * 修改订单状态
     * @param order
     * @return
     */
    @Override
    public int setOrderStatus(Order order) {
        int i = orderDao.setOrderStatus(order);
        return i;
    }

    /**
     * 根据订单id获取完整的vo
     * @param id
     * @return
     */
    @Override
    public OrderVo getOrderVoByOrderId(Long id) {
        OrderVo orderVo = orderDao.getOrderVoByOrderId(id);
        Date date=new Date();
        if(orderVo.getShowTime().getTime()> date.getTime()){
            //0未上映,1已上映
            orderVo.setShowStatus((byte)0);
        }else {
            orderVo.setShowStatus((byte)1);
        }
        return orderVo;
    }
}
