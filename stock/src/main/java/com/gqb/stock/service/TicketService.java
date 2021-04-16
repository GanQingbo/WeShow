package com.gqb.stock.service;

import com.github.pagehelper.PageInfo;
import com.gqb.stock.entity.Ticket;
import com.gqb.stock.entity.vo.TicketLockVo;
import com.gqb.stock.entity.vo.TicketQuery;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author GanQingbo
 * @Classname TicketService
 * @Description
 * @date 2021/3/10 11:09
 */
public interface TicketService {
    int createTicket(Ticket ticket);

    int sellTicket(Long id);

    int getTicketNumber(Long id);

    int updateTicket(Ticket ticket);

    int deleteTicket(Long id);

    Ticket getTicketById(Long id);

    TicketQuery getTicketQueryById(Long id);

    List<Ticket> getTicketByShow(Long showId);

    List<Ticket> getAllTicket();

    BigDecimal getPrice(Long id);

    int getSurplus(Long id);

    PageInfo<TicketQuery> getTicketByPage(int page, int size, TicketQuery ticketQuery);

    long getSellTimeDistance(Long id);

    long getShowIdByTicketId(Long id);

    int ticketLocket(TicketLockVo ticketLockVo)throws Exception;

    int ticketUnLocket(TicketLockVo ticketLockVo);
}
