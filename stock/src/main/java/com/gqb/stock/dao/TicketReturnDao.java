package com.gqb.stock.dao;

import com.gqb.stock.entity.TicketReturn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GanQingbo
 * @Classname TicketReturnDao
 * @Description
 * @date 2021/3/11 9:53
 */
@Mapper
public interface TicketReturnDao {

    TicketReturn getTicketReturnById(@Param("id")Long id);

    List<TicketReturn> getTicketReturnByShow(@Param("showId") Long showId);

    List<TicketReturn> getTicketReturnByTicketId(@Param("ticketId") Long ticketId);

    int createTicketReturn(TicketReturn ticketReturn);

    int deleteTicketReturn(@Param("ticketId") Long ticketId);

    int updateTicketReturn(TicketReturn ticketReturn);

    int getCurrentNo(@Param("ticketId") Long ticketId);

    int getTicketNumber(@Param("ticketId") Long ticketId);
}
