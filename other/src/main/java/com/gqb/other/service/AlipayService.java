package com.gqb.other.service;

import com.gqb.other.entity.Order;

/**
 * @author GanQingbo
 * @Classname AlipayService
 * @Description
 * @date 2021/4/16 0:35
 */
public interface AlipayService {
    String alipay(Order order);
    String alipayRefund(Order order);
}
