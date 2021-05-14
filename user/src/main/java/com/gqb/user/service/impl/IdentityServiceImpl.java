package com.gqb.user.service.impl;

import com.gqb.common.utils.R;
import com.gqb.user.dao.IdentityDao;
import com.gqb.user.entity.Identity;
import com.gqb.user.entity.Order;
import com.gqb.user.entity.TicketSell;
import com.gqb.user.entity.vo.IdentityCheckVo;
import com.gqb.user.feign.StockFeign;
import com.gqb.user.service.IdentityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author GanQingbo
 * @Classname IdentityServiceImpl
 * @Description
 * @date 2021/4/23 18:45
 */
@Service
@Slf4j
public class IdentityServiceImpl implements IdentityService {
    @Resource
    private IdentityDao identityDao;
    @Resource
    private StockFeign stockFeign;

    @Override
    public List<Identity> getIdentityByUser(Long id) {
        List<Identity> identityByUser = identityDao.getIdentityByUser(id);
        return identityByUser;
    }

    @Override
    public int createIdentity(Identity identity) {
        int identity1 = identityDao.createIdentity(identity);
        return identity1;
    }

    @Override
    public int deleteIdentityById(Long id) {
        int i = identityDao.deleteIdentityById(id);
        return i;
    }

    /**
     * ticketId, number[]
     * @param identityCheckVo
     * @return
     */
    @Override
    public boolean identityCheck(IdentityCheckVo identityCheckVo) {
        //1. 获取showid
        R r = stockFeign.getShowIdByTicketId(identityCheckVo.getTicketId());
        Object s = r.getData().get("showId");
        Long showId = Long.valueOf(s.toString());
        //2. 逐一比较
        String[] numbers = identityCheckVo.getNumber();
        List<TicketSell> sells = identityDao.identityCheck(showId);
        for (String number:numbers){
            for(TicketSell sell:sells){
                if(sell.getIdentityNumber().equals(number)){
                    //相等
                    log.info("=====重复购票");
                    return true;
                }
            }
        }
        log.info("=====无购票记录");
        return false;
    }

    /**
     * 添加演出-人唯一关系
     * @param identityCheckVo
     * @return
     */
    @Override
    public int addTicketSell(IdentityCheckVo identityCheckVo) {
        R r = stockFeign.getShowIdByTicketId(identityCheckVo.getTicketId());
        Object s = r.getData().get("showId");
        Long showId = Long.valueOf(s.toString());
        for(String number:identityCheckVo.getNumber()){
            TicketSell ticketSell = new TicketSell();
            ticketSell.setShowId(showId);
            ticketSell.setIdentityNumber(number);
            int i = identityDao.createTicketSell(ticketSell);
            if (i<=0){ //失败
                return -1;
            }
        }
        log.info("=====添加购票记录成功");
        return 0;
    }

    /**
     * 删除购票记录
     * @param order
     * @return
     */
    @Override
    public int deleteTicketSell(Order order) {
        TicketSell ticketSell = new TicketSell();
        ticketSell.setShowId(order.getShowId());
        Long userId = order.getUserId();
        //获取身份证列表
        List<Identity> list = identityDao.getIdentityByUser(userId);
        for(Identity identity:list){
            ticketSell.setIdentityNumber(identity.getNumber());
            int i = identityDao.deleteTicketSell(ticketSell);
            if(i<0){
                //出错
                log.info("=====售票记录删除失败");
            }
        }
        return 1;
    }
}
