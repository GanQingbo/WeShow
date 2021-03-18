package com.gqb.order.dao;

import com.gqb.order.entity.OrderReturn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: WeShow
 * @description:
 * @author: Gan
 * @date: 2021-03-18 22:33
 **/
@Mapper
public interface OrderReturnDao {

    //提交申请退票
    int createOrderReturn(OrderReturn orderReturn);
    //处理退票
    int updateOrderReturn(OrderReturn orderReturn);
    //查看退票list
    List<OrderReturn> getOrderReturnQuery(OrderReturn orderReturn);
}
