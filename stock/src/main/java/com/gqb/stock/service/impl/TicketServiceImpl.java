package com.gqb.stock.service.impl;

import com.gqb.stock.dao.TicketDao;
import com.gqb.stock.dao.TicketReturnDao;
import com.gqb.stock.entity.Ticket;
import com.gqb.stock.entity.TicketReturn;
import com.gqb.stock.service.TicketService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author GanQingbo
 * @Classname TicketServiceImpl
 * @Description
 * @date 2021/3/10 11:09
 */
@Service
public class TicketServiceImpl implements TicketService {
    @Resource
    private TicketDao ticketDao;

    @Resource
    private TicketReturnDao returnDao;

    @Override
    public int createTicket(Ticket ticket) {
        //初始化余票数等于总票数
        ticket.setSeatSurplus(ticket.getSeatNumber());
        int i = ticketDao.createTicket(ticket);
        return i;
    }

    @Override
    public int sellTicket(Long id) {
        //根据seatSurplus判断是否还有余票,再判断returnStatus看是否有退票，优先出售退票
        //出票：currentNo+1，seatSurplus-1
        int surplus = ticketDao.getSurplus(id);
        if(surplus>0){
            //有余票
            byte returnStatus = ticketDao.getReturnStatus(id);
            if(returnStatus==0){
                //退票表无票,从大表出票
                int currentNo = ticketDao.getCurrentNo(id);
                int i = ticketDao.sellTicket(id);
                if(i>0){
                    //返回座位号
                    return currentNo;
                }else {
                    return -1;
                }
            }else {
                //从退票票出票,并返回座位号
                int currentNo=returnDao.getCurrentNo(id);
                int i = returnDao.deleteTicketReturn(id);
                if(i>0){
                    //余票数-1
                    ticketDao.updateSurplusReduce(id);
                    int ticketNumber = returnDao.getTicketNumber(id);
                    if(ticketNumber==0){
                        //更新ticket表return状态
                        ticketDao.updateReturnStatus(id);
                    }
                    return currentNo;
                }else {
                    return -1;
                }
            }
        }
        return -1;
    }

    @Override
    public int getTicketNumber(Long id) {
        int num=ticketDao.getTicketNumber(id);
        return num;
    }

    @Override
    public int updateTicket(Ticket ticket) {
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
