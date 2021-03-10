package com.gqb.stock.dao;

import com.gqb.stock.entity.Ticket;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GanQingbo
 * @Classname TicketDao
 * @Description
 * @date 2021/3/10 10:32
 */
@Mapper
public interface TicketDao {

    int createTicket(Ticket ticket);

    int sellTicket(@Param("id") Long id);

    int getTicketNumber(@Param("id") Long id);

    int updateTicket(Ticket ticket);

    int deleteTicket(@Param("id") Long id);

    Ticket getTicketById(@Param("id") Long id);

    List<Ticket> getTicketByShow(@Param("showId") Long showId);

    List<Ticket> getAllTicket();
}
