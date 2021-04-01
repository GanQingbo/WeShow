package com.gqb.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gqb.common.utils.R;
import com.gqb.order.client.StockClient;
import com.gqb.order.dao.OrderDao;
import com.gqb.order.dao.OrderReturnDao;
import com.gqb.order.entity.Order;
import com.gqb.order.entity.OrderReturn;
import com.gqb.order.service.OrderService;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    OrderDao orderDao;

    @Resource
    StockClient stockClient;

    @Resource
    OrderReturnDao returnDao;

    @Resource
    RabbitTemplate rabbitTemplate;

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
    @RabbitListener(queues = {"order-create-queue"})
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
     * @param orderReturn
     * @return
     */
    @Override
    public int createOrderReturn(OrderReturn orderReturn) {
        int orderReturn1 = returnDao.createOrderReturn(orderReturn);
        return orderReturn1;
    }

    @Override
    public int updateOrderReturn(OrderReturn orderReturn) {
        orderReturn.setAdminId(1001L);
        orderReturn.setHandleTime(new Date());
        Order order = orderDao.getOrderById(orderReturn.getOrderId());
        if (order != null) {
            orderReturn.setReturnMoney(order.getOrderAmount());
        }
        int i = returnDao.updateOrderReturn(orderReturn);
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
}