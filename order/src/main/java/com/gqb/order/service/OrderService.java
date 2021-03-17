package com.gqb.order.service;

import com.gqb.order.entity.Order;

/**
 * @author GanQingbo
 * @Classname OrderService
 * @Description
 * @date 2021/3/15 9:51
 */
public interface OrderService {
    int createOrder(Order order);
    int secKill(Order order);
    int updateTicket(Order order);
}
