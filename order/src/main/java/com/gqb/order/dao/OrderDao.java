package com.gqb.order.dao;

import com.gqb.order.entity.Order;
import com.gqb.order.entity.OrderReturn;
import com.gqb.order.entity.vo.OrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    List<Order> getAllOrders();

    List<Order> getOrderQuery(Order order);

    Order getOrderById(@Param("id") Long id);

    int updateOrder(Order order);

    int deleteOrder(@Param("id") Long id);

    int updateOrderDeleteStatus(Order order);

    List<Order> getOrderByUserId(@Param("id") Long id);

    int setOrderStatus(Order order);

    List<OrderVo> getOrderVoByUserId(@Param("id") Long id);
    OrderVo  getOrderVoByOrderId(@Param("id") Long id);
}
