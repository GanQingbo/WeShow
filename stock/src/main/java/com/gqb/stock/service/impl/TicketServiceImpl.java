package com.gqb.stock.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gqb.stock.dao.TicketDao;
import com.gqb.stock.dao.TicketReturnDao;
import com.gqb.stock.entity.Ticket;
import com.gqb.stock.entity.vo.TicketQuery;
import com.gqb.stock.service.TicketService;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

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

    /**
     * 分页带查询结果
     * @param page
     * @param size
     * @param ticketQuery
     * @return
     */
    @Override
    public PageInfo<TicketQuery> getTicketByPage(int page, int size, TicketQuery ticketQuery) {
        PageHelper.startPage(page, size);
        List<TicketQuery> ticketByQuery = ticketDao.getTicketByQuery(ticketQuery);
        PageInfo<TicketQuery> info= new PageInfo<>(ticketByQuery);
        return info;
    }

    @Override
    public int createTicket(Ticket ticket) {
        //初始化余票数等于总票数
        ticket.setSeatSurplus(ticket.getSeatNumber());
        int i = ticketDao.createTicket(ticket);
        if (i > 0) {
            //初始化redis库存
            Jedis jedis = new Jedis("159.75.112.187", 6379);
            jedis.auth("123456");
            String stockKey = "SecKill:" + "stock:" + ticket.getId();
            jedis.set(stockKey, String.valueOf(ticket.getSeatNumber()));
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
    @RabbitListener(queues = {"stock-update-queue"})
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
        if(ticket.getSeatNumber()<ticket.getSeatSurplus()){
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

    @Override
    public int getSurplus(Long id) {
        Integer surplus = ticketDao.getSurplus(id);
        return surplus;
    }
}
