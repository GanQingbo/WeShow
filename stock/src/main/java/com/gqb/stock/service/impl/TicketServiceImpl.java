package com.gqb.stock.service.impl;

import com.gqb.stock.dao.TicketDao;
import com.gqb.stock.entity.Ticket;
import com.gqb.stock.service.TicketService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Override
    public int createTicket(Ticket ticket) {
        //初始化余票数等于总票数
        ticket.setSeatSurplus(ticket.getSeatNumber());
        int i = ticketDao.createTicket(ticket);
        return i;
    }

    @Override
    public int sellTicket(Long id) {
        //判断是否还有余票
        int num= ticketDao.getTicketNumber(id);
        if(num>0){
            int isSell = ticketDao.sellTicket(id);
            return isSell;
        }
        return 0;
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
}
