package com.gqb.order.controller;

import com.github.pagehelper.PageInfo;
import com.gqb.common.utils.R;
import com.gqb.order.entity.Order;
import com.gqb.order.entity.vo.ConfirmResponseVo;
import com.gqb.order.entity.vo.ConfirmVo;
import com.gqb.order.entity.vo.OrderVo;
import com.gqb.order.entity.vo.TicketLockVo;
import com.gqb.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author GanQingbo
 * @Classname OrderController
 * @Description
 * @date 2021/3/10 9:51
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    OrderService orderService;

    /**
     * 售票
     *
     * @param order
     * @return
     */
    @PostMapping("/createOrder")
    public R createOrder(@RequestBody Order order) {
        int i = orderService.createOrder(order);
        if (i > 0) {
            return R.ok().data("order", order);
        }
        return R.error().message("创建订单失败");
    }

    /**
     * 售票,走一般的流程
     *
     * @return
     */
    @PostMapping("/secKillTest")
    public R createMuchOrder(@RequestBody Order order) {
        int i = orderService.secKill(order);
        if (i > 0) {
            return R.ok().data("order", order);
        }
        return R.error().message("创建订单失败");
    }

    @PostMapping("/getAllOrder/{page}/{size}")
    public R getAllOrder(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @RequestBody Order order) {
        PageInfo<Order> orderByPage = orderService.getOrderByPage(page, size, order);
        return R.ok().data("order", orderByPage);
    }

    //根据订单的id获取订单信息
    @GetMapping("/getOrderById/{id}")
    public R getOrderById(@PathVariable("id") Long id) {
        Order orderById = orderService.getOrderById(id);
        return R.ok().data("order", orderById);
    }

    @PostMapping("/updateOrder")
    public R updateOrder(@RequestBody Order order) {
        int i = orderService.updateOrder(order);
        if (i > 0) {
            return R.ok().message("更新订单信息成功");
        }
        return R.error().message("更新订单信息失败");
    }

    @DeleteMapping("/deleteOrder/{id}")
    public R deleteOrder(@PathVariable("id") Long id) {
        //物理删除
        int i = orderService.deleteOrder(id);
        if (i > 0) {
            return R.ok().message("删除订单成功");
        }
        return R.error().message("删除订单失败");
    }

    @PostMapping("/updateDeleteStatus/{id}")
    public R updateDeleteStatus(@PathVariable("id") Long id) {
        //逻辑删除
        int i = orderService.updateOrderDeleteStatus(id);
        if (i > 0) {
            return R.ok().message("状态更新成功");
        }
        return R.error().message("状态更新失败");
    }

    /**
     * 获取订单Token
     *
     * @param id
     * @return
     */
    @GetMapping("/getOrderToken/{id}")
    public R getOrderToken(@PathVariable("id") Long id) {
        String orderToken = orderService.getOrderToken(id);
        return R.ok().data("token", orderToken);
    }

    /**
     * 提交订单
     * @param confirmVo
     * @return
     */
    @PostMapping("/submitOrder")
    public R submitOrder(@RequestBody ConfirmVo confirmVo) {
        ConfirmResponseVo vo = orderService.orderConfirm(confirmVo);
        switch (vo.getCode()){
            case 0:
                return R.ok().data("response",vo);
            case 1:
                return R.error().message("OrderToken验证失败");
            case 2:
                return R.error().message("远程调用库存锁定失败");
            case 3:
                return R.error().message("订单创建失败");
            default:
                return R.error().message("未知错误");
        }
    }

    /**
     * 支付成功后修改订单
     * @param ticketLockVo
     * @return
     */
    @PostMapping("/paySuccess")
    public R paySuccess(@RequestBody TicketLockVo ticketLockVo){
        int i = orderService.orderPaySuccess(ticketLockVo);
        if(i==0){
            return R.ok();
        }else if(i==1){
            return R.error().message("订单状态更新失败");
        }else if(i==2){
            return R.error().message("远程扣减库存失败");
        }else {
            return R.error().message("不可预料的错误");
        }
    }

    /**
     * 根据用户id获取演出 票夹
     */
    @GetMapping("/getShowsByUserId/{id}")
    public R getShowsByUserId(@PathVariable("id") Long id){
        List<Long> showsByUser = orderService.getShowsByUser(id);
        return R.ok().data("showId",showsByUser);
    }

    /**
     * 修改订单状态
     * @param order
     * @return
     */
    @PostMapping("/setOrderStatus")
    public R setOrderStatus(@RequestBody Order order){
        int i = orderService.setOrderStatus(order);
        if(i>0){
            return R.ok().message("修改订单状态成功");
        }
        return R.error().message("修改订单状态失败");
    }

    //根据用户id获取所有订单
    @GetMapping("/getOrderVoByUserId/{id}")
    public R getOrderByUserId(@PathVariable("id") Long id){
        List<OrderVo> orderVoByUserId = orderService.getOrderVoByUserId(id);
        return R.ok().data("order",orderVoByUserId);
    }

    @GetMapping("/getOrderVoByOrderId/{id}")
    public R getOrderByOrderId(@PathVariable("id") Long id){
        OrderVo order = orderService.getOrderVoByOrderId(id);
        return R.ok().data("order",order);
    }
}
