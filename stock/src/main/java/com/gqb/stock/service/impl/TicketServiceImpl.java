package com.gqb.stock.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gqb.common.utils.R;
import com.gqb.stock.dao.TicketDao;
import com.gqb.stock.dao.TicketReturnDao;
import com.gqb.stock.entity.Ticket;
import com.gqb.stock.entity.vo.Order;
import com.gqb.stock.entity.vo.TicketLockVo;
import com.gqb.stock.entity.vo.TicketQuery;
import com.gqb.stock.feign.OrderFeign;
import com.gqb.stock.service.TicketService;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author GanQingbo
 * @Classname TicketServiceImpl
 * @Description
 * @date 2021/3/10 11:09
 */
@Service
@Slf4j
public class TicketServiceImpl implements TicketService {
    @Resource
    private TicketDao ticketDao;

    @Resource
    private TicketReturnDao returnDao;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Resource
    private OrderFeign orderFeign;

    /**
     * 分页带查询结果
     *
     * @param page
     * @param size
     * @param ticketQuery
     * @return
     */
    @Override
    public PageInfo<TicketQuery> getTicketByPage(int page, int size, TicketQuery ticketQuery) {
        PageHelper.startPage(page, size);
        List<TicketQuery> ticketByQuery = ticketDao.getTicketByQuery(ticketQuery);
        PageInfo<TicketQuery> info = new PageInfo<>(ticketByQuery);
        return info;
    }

    /**
     * 库存加载到Redis中
     *
     * @param ticket
     * @return
     */
    @Override
    public int createTicket(Ticket ticket) {
        //初始化余票数等于总票数
        ticket.setSeatSurplus(ticket.getSeatNumber());
        int i = ticketDao.createTicket(ticket);
        if (i > 0) {
            //初始化redis库存
//            Jedis jedis = new Jedis("159.75.112.187", 6379);
//            jedis.auth("123456");
//            jedis.set(stockKey, String.valueOf(ticket.getSeatNumber()));
            String stockKey = "Ticket:" + "stock:" + ticket.getId();
            redisTemplate.opsForValue().set(stockKey, String.valueOf(ticket.getSeatNumber()));
            log.info("=====>redis库存加载完成");
        }
        return i;
    }

    @Override
    public int sellTicket(Long id) {
        //根据seatSurplus判断是否还有余票,再判断returnStatus看是否有退票，优先出售退票
        //出票：currentNo+1，seatSurplus-1
        int surplus = ticketDao.getSurplus(id);
        if (surplus > 0) {
            //有余票
            byte returnStatus = ticketDao.getReturnStatus(id);
            if (returnStatus == 0) {
                //退票表无票,从大表出票
                int currentNo = ticketDao.getCurrentNo(id);
                int i = ticketDao.sellTicket(id);
                if (i > 0) {
                    //返回座位号
                    return currentNo;
                } else {
                    return -1;
                }
            } else {
                //从退票票出票,并返回座位号
                int currentNo = returnDao.getCurrentNo(id);
                int i = returnDao.deleteTicketReturn(id);
                if (i > 0) {
                    //余票数-1
                    ticketDao.updateSurplusReduce(id);
                    int ticketNumber = returnDao.getTicketNumber(id);
                    if (ticketNumber == 0) {
                        //更新ticket表return状态
                        ticketDao.updateReturnStatus(id);
                    }
                    return currentNo;
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }

    /**
     * 根据消息扣减库存
     *
     * @param id
     * @return
     */
    //@RabbitListener(queues = {"stock-update-queue"})
    public void secKillTicket(Message message, Long id, Channel channel) {
        log.info("Stock=====>收到扣减库存的消息");
        //channel内自增的tag
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        //判断returnStatus看是否有退票，优先出售大票表
        //出票：currentNo+1，seatSurplus-1
        byte returnStatus = ticketDao.getReturnStatus(id);
        if (returnStatus == 0) {
            //退票表无票,从大表出票
            synchronized (this) { //加锁
                int currentNo = ticketDao.getCurrentNo(id);
                int i = ticketDao.sellTicket(id);
                try {
                    if (i > 0) {
                        //更新库存表成功，确认消息
                        log.info("Stock=====>扣减库存成功");
                        channel.basicAck(deliveryTag, false);
                        return;
                    } else {
                        //不放回队列
                        channel.basicNack(deliveryTag, false, true);
                    }
                } catch (IOException e) {
                    //网络异常
                    e.printStackTrace();
                }
            }
        } else {
            //从退票票出票,并返回座位号
            synchronized (this) {
                int currentNo = returnDao.getCurrentNo(id);
                int i = returnDao.deleteTicketReturn(id);
                try {
                    if (i > 0) {
                        //余票数-1
                        ticketDao.updateSurplusReduce(id);
                        int ticketNumber = returnDao.getTicketNumber(id);
                        if (ticketNumber == 0) {
                            //更新ticket表return状态
                            ticketDao.updateReturnStatus(id);
                        }
                        //更新库存表成功，确认消息
                        channel.basicAck(deliveryTag, false);
                        return;
                    } else {
                        channel.basicNack(deliveryTag, false, true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Override
    public int getTicketNumber(Long id) {
        int num = ticketDao.getTicketNumber(id);
        return num;
    }

    @Override
    public int updateTicket(Ticket ticket) {
        if (ticket.getSeatNumber() < ticket.getSeatSurplus()) {
            //数据不正确
            return -1;
        }
        int i = ticketDao.updateTicket(ticket);
        return i;
    }

    @Override
    public int deleteTicket(Long id) {
        int i = ticketDao.deleteTicket(id);
        return i;
    }

    @Override
    public Ticket getTicketById(Long id) {
        Ticket ticketById = ticketDao.getTicketById(id);
        return ticketById;
    }

    @Override
    public TicketQuery getTicketQueryById(Long id) {
        TicketQuery query = ticketDao.getTicketQueryById(id);
        return query;
    }

    @Override
    public List<Ticket> getTicketByShow(Long showId) {
        List<Ticket> ticketByShow = ticketDao.getTicketByShow(showId);
        return ticketByShow;
    }

    @Override
    public List<Ticket> getAllTicket() {
        List<Ticket> list = ticketDao.getAllTicket();
        return list;
    }

    @Override
    public BigDecimal getPrice(Long id) {
        BigDecimal price = ticketDao.getPrice(id);
        return price;
    }

    /**
     * 从Redis中获取库存数量
     *
     * @param id
     * @return
     */
    @Override
    public int getSurplus(Long id) {
        String uuid = UUID.randomUUID().toString();
        //锁60s
        Boolean lock = stringRedisTemplate.opsForValue().setIfAbsent("TicketStockLock", uuid, 60, TimeUnit.SECONDS);
        Integer surplus = 0;
        if (lock) {
            //加锁成功
            log.info("=====Ticket库存加锁，UUID：" + uuid);
            try {
                String stockKey = "Ticket:" + "stock:" + id;
                String s = stringRedisTemplate.opsForValue().get(stockKey);
                if (StringUtils.isEmpty(s)) {
                    //读DB
                    surplus = ticketDao.getSurplus(id);
                    log.info("=====Ticket库存缓存没命中，从DB获取数量为：" + surplus);
                    //放进Redis
                    stringRedisTemplate.opsForValue().set(stockKey, surplus.toString());
                    return surplus;
                } else {
                    //不空才赋值
                    surplus = Integer.valueOf(s);
                }
            } finally {
                //释放锁
                if (uuid.equals(stringRedisTemplate.opsForValue().get("TicketStockLock"))) {
                    stringRedisTemplate.delete("TicketStockLock");
                    log.info("=====Ticket库存解锁，UUID：" + uuid);
                }
            }
        } else {
            //加锁失败，利用自旋机制重试
            log.info("=====TicketStockLock获得锁失败，正在自旋");
            try {
                Thread.sleep(300);
            } catch (Exception e) {

            }
        }
        return surplus;
    }

    /**
     * 计算距离开售时间
     *
     * @param id
     * @return 秒
     */
    @Override
    public long getSellTimeDistance(Long id) {
        Ticket ticket = ticketDao.getTicketById(id);
        Date sellTime = ticket.getSellTime();
        Date now = new Date();
        long diff = sellTime.getTime() - now.getTime();
        return diff;
    }

    @Override
    public long getShowIdByTicketId(Long id) {
        Long showIdByTicketId = ticketDao.getShowIdByTicketId(id);
        return showIdByTicketId;
    }

    /**
     * 锁定库存
     * 库存解锁：过期订单未支付，用户主动关闭订单
     *
     * @param ticketLockVo
     * @return
     */
    @Transactional
    @Override
    public int ticketLocket(TicketLockVo ticketLockVo) throws Exception {
        Integer surplus = ticketDao.getSurplus(ticketLockVo.getId());
        log.info("TicketId:" + ticketLockVo.getId() + "的库存：" + surplus);
        if (surplus <= 0) {
            log.info("TicketId:" + ticketLockVo.getId() + "库存不足");
            throw new RuntimeException("TicketId:" + ticketLockVo.getId() + "库存不足");
        }
        int i = ticketDao.updateTicketLocked(ticketLockVo);
        if (i == 0) {
            //锁库存失败
            throw new RuntimeException("TicketId:" + ticketLockVo.getId() + "库存不足");
        }
        //库存锁定成功，发送消息
        rabbitTemplate.convertAndSend("stock-event-exchange", "stock.locked", ticketLockVo, new CorrelationData(UUID.randomUUID().toString()));
        log.info("=====库存锁定成功，消息发送成功，订单id是" + ticketLockVo.getOrderId());
        return i;
    }

    /**
     * 解锁库存
     * 1. 订单过期未支付
     * 2. 用户主动取消
     */
    /**
     * 库存自动解锁
     * @param message
     * @param ticketLockVo
     * @param channel
     */
    @RabbitListener(queues = "stock.release.queue")
    public void stockAutoLocket(Message message, TicketLockVo ticketLockVo, Channel channel) {
        log.info("Stock=====>收到订单关闭的消息");
        //channel内自增的tag
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        //1.先查询订单状态，15分钟还未支付的关闭订单
        R r = orderFeign.getOrderById(ticketLockVo.getOrderId());
        Object data = r.getData().get("order");
        String json = JSONObject.toJSON(data).toString();
        Order order = JSON.parseObject(json, Order.class);
        log.info("Stock=====>收到订单Id是:"+order.getId());
        try {
            //状态0是未支付的订单
            if (order.getOrderStatus() == (byte) 0) {
                //2.解锁库存，更新redis票数
                int i = ticketUnLocket(ticketLockVo);
                //3.修改订单状态为已关闭 4
                if (i > 0) {
                    order.setOrderStatus((byte) 4);
                    //更新订单状态
                    R r1 = orderFeign.setOrderStatus(order);
                    if (r1.getSuccess() == true) {
                        log.info("=====超时订单关闭成功，订单id："+order.getId());
                        channel.basicAck(deliveryTag, false);
                    }else {
                        //直接丢弃
                        channel.basicNack(deliveryTag,false,false);
                    }
                }else {
                    log.info("=====超时订单库存解锁失败");
                    //重新放入队列
                    channel.basicNack(deliveryTag,false,true);
                }
            }
            //不是待支付的订单也处理
            log.info("=====订单处理消息确认");
            channel.basicAck(deliveryTag, false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 支付成功，库存解锁
     *
     * @param ticketLockVo
     * @return
     */
    @Override
    public int ticketUnLocket(TicketLockVo ticketLockVo) {
        int i = ticketDao.updateTicketUnLocked(ticketLockVo);
        //更新redis
        String uuid = UUID.randomUUID().toString();
        Boolean lock = stringRedisTemplate.opsForValue().setIfAbsent("TicketStockLock", uuid, 60, TimeUnit.SECONDS);
        Integer surplus = 0;
        if (lock) {
            //加锁成功
            log.info("=====Ticket库存加锁，UUID：" + uuid);
            try {
                String stockKey = "Ticket:" + "stock:" + ticketLockVo.getId();
                surplus = ticketDao.getSurplus(ticketLockVo.getId());
                log.info("=====Ticket更新库存缓存，从DB获取数量为：" + surplus);
                //放进Redis
                stringRedisTemplate.opsForValue().set(stockKey, surplus.toString());
            } finally {
                //释放锁
                if (uuid.equals(stringRedisTemplate.opsForValue().get("TicketStockLock"))) {
                    stringRedisTemplate.delete("TicketStockLock");
                    log.info("=====Ticket库存解锁，UUID：" + uuid);
                }
            }
        } else {
            //加锁失败，利用自旋机制重试
            log.info("=====TicketStockLock获得锁失败，正在重试");
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    /**
     * 归还库存
     * @param ticketLockVo
     * @return
     */
    @Override
    public int ticketReturn(TicketLockVo ticketLockVo) {
        int i = ticketDao.ticketReturn(ticketLockVo);
        if(i>0){
            //更新redis
            String uuid = UUID.randomUUID().toString();
            Boolean lock = stringRedisTemplate.opsForValue().setIfAbsent("TicketStockLock", uuid, 60, TimeUnit.SECONDS);
            Integer surplus = 0;
            if (lock) {
                //加锁成功
                log.info("=====Ticket库存加锁，UUID：" + uuid);
                try {
                    String stockKey = "Ticket:" + "stock:" + ticketLockVo.getId();
                    surplus = ticketDao.getSurplus(ticketLockVo.getId());
                    log.info("=====Ticket更新库存缓存，从DB获取数量为：" + surplus);
                    //放进Redis
                    stringRedisTemplate.opsForValue().set(stockKey, surplus.toString());
                } finally {
                    //释放锁
                    if (uuid.equals(stringRedisTemplate.opsForValue().get("TicketStockLock"))) {
                        stringRedisTemplate.delete("TicketStockLock");
                        log.info("=====Ticket库存解锁，UUID：" + uuid);
                    }
                }
            } else {
                //加锁失败，利用自旋机制重试
                log.info("=====TicketStockLock获得锁失败，正在重试");
                try {
                    Thread.sleep(300);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return i;
    }
}
