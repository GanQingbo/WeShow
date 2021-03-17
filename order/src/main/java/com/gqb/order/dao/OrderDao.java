package com.gqb.order.dao;

import com.gqb.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author GanQingbo
 * @Classname OrderDao
 * @Description
 * @date 2021/3/13 11:51
 */
@Mapper
public interface OrderDao {
    int createOrder(Order order);
    int updateSeatAndAmount(Order order);
}
