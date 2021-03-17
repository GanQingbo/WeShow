package com.gqb.order.service.impl;

import com.gqb.common.utils.R;
import com.gqb.order.client.StockClient;
import com.gqb.order.dao.OrderDao;
import com.gqb.order.entity.Order;
import com.gqb.order.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author GanQingbo
 * @Classname OrderServiceImpl
 * @Description
 * @date 2021/3/15 9:52
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderDao orderDao;

    @Resource
    StockClient stockClient;

    /**
     * 一般方法创建订单-减库存
     * @param order
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int createOrder(Order order) {

        int i = orderDao.createOrder(order);
        if(i>0){
            //创建订单成功，开始减库存
            R r = stockClient.sellTicket(order.getTicketId());
            //更新订单信息
            BigDecimal price = stockClient.getPriceById(order.getTicketId());
            order.setSeatNo((int)r.getData().get("seat_no"));
            order.setOrderAmount(price);
            orderDao.updateSeatAndAmount(order);
            //返回座位号
            return (int)r.getData().get("seat_no");
        }
        return -1;
    }

    @Override
    public int secKill(Order order) {
        return 0;
    }

    @Override
    public int updateTicket(Order order) {
        int i = orderDao.updateSeatAndAmount(order);
        return i;
    }
}
