package com.gqb.user.service;

import com.gqb.user.entity.Identity;
import com.gqb.user.entity.Order;
import com.gqb.user.entity.vo.IdentityCheckVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GanQingbo
 * @Classname IdentityService
 * @Description
 * @date 2021/4/23 18:45
 */
public interface IdentityService {
    List<Identity> getIdentityByUser(Long id);

    int createIdentity(Identity identity);

    int deleteIdentityById(Long id);

    boolean identityCheck(IdentityCheckVo identityCheckVo);

    int addTicketSell(IdentityCheckVo identityCheckVo);

    int deleteTicketSell(Order order);
}
