package com.gqb.order.service;

import com.github.pagehelper.PageInfo;
import com.gqb.order.entity.Order;
import com.gqb.order.entity.OrderReturn;
import com.gqb.order.entity.vo.ConfirmResponseVo;
import com.gqb.order.entity.vo.ConfirmVo;
import com.gqb.order.entity.vo.OrderVo;
import com.gqb.order.entity.vo.TicketLockVo;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;

import java.util.List;

/**
 * @author GanQingbo
 * @Classname OrderService
 * @Description
 * @date 2021/3/15 9:51
 */
public interface OrderService {
    int createOrder(Order order);
    void secKillByMessage(Message message, Order order, Channel channel);
    int secKill(Order order);
    int updateTicket(Order order);
    PageInfo<Order> getOrderByPage(Integer page, Integer size, Order order);
    Order getOrderById(Long id);
    int updateOrder(Order order);
    int deleteOrder(Long id);
    int updateOrderDeleteStatus(Long id);
    int sendCreateRequest(Order order);

    //提交申请退票
    int createOrderReturn(Long id);
    //处理退票
    int updateOrderReturn(OrderReturn orderReturn);
    //查看退票list
    PageInfo<OrderReturn> getOrderReturnQuery(Integer page,Integer size,OrderReturn orderReturn);

    ConfirmResponseVo orderConfirm(ConfirmVo confirmVo);

    String getOrderToken(Long userId);

    int orderPaySuccess(TicketLockVo ticketLockVo);

    List<Order> getOrderByUserId(Long id);

    List<Long> getShowsByUser(Long id);

    int setOrderStatus(Order order);

    List<OrderVo> getOrderVoByUserId(Long id);

    OrderVo getOrderVoByOrderId(Long id);
}
