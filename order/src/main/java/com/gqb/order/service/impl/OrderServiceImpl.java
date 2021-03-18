package com.gqb.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gqb.common.utils.R;
import com.gqb.order.client.StockClient;
import com.gqb.order.dao.OrderDao;
import com.gqb.order.dao.OrderReturnDao;
import com.gqb.order.entity.Order;
import com.gqb.order.entity.OrderReturn;
import com.gqb.order.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    @Resource
    OrderReturnDao returnDao;

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

    /**
     * 带查询结果的分页
     * @param page
     * @param size
     * @param order
     * @return
     */
    @Override
    public PageInfo<Order> getOrderByPage(Integer page, Integer size, Order order) {
        //开启分页
        PageHelper.startPage(page,size);
        System.out.println(order.getDeleteStatus());
        List<Order> query = orderDao.getOrderQuery(order);
        //封装到PageInfo
        PageInfo<Order> pageInfo=new PageInfo<>(query);
        return pageInfo;
    }

    @Override
    public Order getOrderById(Long id) {
        Order orderById = orderDao.getOrderById(id);
        return orderById;
    }

    @Override
    public int updateOrder(Order order) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        order.setUpdateTime(date);
        int i = orderDao.updateOrder(order);
        return i;
    }

    /**
     * 物理删除
     * @param id
     * @return
     */
    @Override
    public int deleteOrder(Long id) {
        int i = orderDao.deleteOrder(id);
        return i;
    }

    /**
     * 逻辑删除，删除状态改变
     * @param id
     * @return
     */
    @Override
    public int updateOrderDeleteStatus(Long id) {
        Order order = orderDao.getOrderById(id);
        if(order.getDeleteStatus()==0){
            order.setDeleteStatus((byte)1);
        }else {
            order.setDeleteStatus((byte)0);
        }
        int i = orderDao.updateOrderDeleteStatus(order);
        return i;
    }

    /**
     * 退票相关，创建一个退票申请
     * @param orderReturn
     * @return
     */
    @Override
    public int createOrderReturn(OrderReturn orderReturn) {
        int orderReturn1 = returnDao.createOrderReturn(orderReturn);
        return orderReturn1;
    }

    @Override
    public int updateOrderReturn(OrderReturn orderReturn) {
        orderReturn.setAdminId(1001L);
        orderReturn.setHandleTime(new Date());
        Order order = orderDao.getOrderById(orderReturn.getOrderId());
        if(order!=null){
            orderReturn.setReturnMoney(order.getOrderAmount());
        }
        int i = returnDao.updateOrderReturn(orderReturn);
        return i;
    }

    /**
     * 带分页的查询结果
     * @param page
     * @param size
     * @param orderReturn
     * @return
     */
    @Override
    public PageInfo<OrderReturn> getOrderReturnQuery(Integer page, Integer size, OrderReturn orderReturn) {
        PageHelper.startPage(page,size);
        List<OrderReturn> orderReturnQuery = returnDao.getOrderReturnQuery(orderReturn);
        PageInfo<OrderReturn> pageInfo = new PageInfo<>(orderReturnQuery);
        return pageInfo;
    }
}
