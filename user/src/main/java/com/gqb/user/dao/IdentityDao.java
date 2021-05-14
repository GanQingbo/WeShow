package com.gqb.user.dao;

import com.gqb.user.entity.Identity;
import com.gqb.user.entity.TicketSell;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GanQingbo
 * @Classname IdentityDao
 * @Description
 * @date 2021/4/23 18:45
 */
@Mapper
public interface IdentityDao {
    List<Identity> getIdentityByUser(@Param("id") Long id);

    int createIdentity(Identity identity);

    int deleteIdentityById(@Param("id") Long id);

    List<TicketSell> identityCheck(@Param("id") Long id);

    int createTicketSell(TicketSell ticketSell);

    int deleteTicketSell(TicketSell ticketSell);
}
