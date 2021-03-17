package com.gqb.stock.dao;

import com.gqb.stock.entity.Ticket;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author GanQingbo
 * @Classname TicketDao
 * @Description
 * @date 2021/3/10 10:32
 */
@Mapper
public interface TicketDao {

    Integer createTicket(Ticket ticket);

    Integer updateSurplusReduce(@Param("id") Long id);

    Integer updateSurplusPlus(@Param("id") Long id);

    Integer updateReturnStatus(@Param("id") Long id);

    Integer getTicketNumber(@Param("id") Long id);

    Byte getReturnStatus(@Param("id") Long id);

    Integer getSurplus(@Param("id") Long id);

    Integer getCurrentNo(@Param("id") Long id);

    Integer sellTicket(@Param("id") Long id);

    Integer updateTicket(Ticket ticket);

    Integer deleteTicket(@Param("id") Long id);

    Ticket getTicketById(@Param("id") Long id);

    List<Ticket> getTicketByShow(@Param("showId") Long showId);

    List<Ticket> getAllTicket();

    BigDecimal getPrice(@Param("id") Long id);
}
