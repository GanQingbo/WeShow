package com.gqb.order.controller;

import com.github.pagehelper.PageInfo;
import com.gqb.common.utils.R;
import com.gqb.order.entity.Order;
import com.gqb.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author GanQingbo
 * @Classname OrderController
 * @Description
 * @date 2021/3/10 9:51
 */
@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Resource
    OrderService orderService;

    /**
     * 售票
     * @param order
     * @return
     */
    @PostMapping("/createOrder")
    public R createOrder(@RequestBody Order order){
        int i = orderService.createOrder(order);
        if(i>0){
            return R.ok().data("order",order);
        }
        return R.error().message("创建订单失败");
    }

    /**
     * 售票
     * @return
     */
    @PostMapping("/secKill")
    public R createMuchOrder(@RequestBody Order order){
        int i = orderService.secKill(order);
        if(i>0){
            return R.ok().data("order",order);
        }
        return R.error().message("创建订单失败");
    }

    @PostMapping("/getAllOrder/{page}/{size}")
    public R getAllOrder(@PathVariable("page") Integer page,@PathVariable("size") Integer size,@RequestBody Order order){
        PageInfo<Order> orderByPage = orderService.getOrderByPage(page, size, order);
        return R.ok().data("order",orderByPage);
    }

    @GetMapping("/getOrderById/{id}")
    public R getOrderById(@PathVariable("id") Long id){
        Order orderById = orderService.getOrderById(id);
        return R.ok().data("order",orderById);
    }

    @PostMapping("/updateOrder")
    public R updateOrder(@RequestBody Order order){
        int i = orderService.updateOrder(order);
        if(i>0){
            return R.ok().message("更新订单信息成功");
        }
        return R.error().message("更新订单信息失败");
    }

    @DeleteMapping("/deleteOrder/{id}")
    public R deleteOrder(@PathVariable("id") Long id){
        //物理删除
        int i = orderService.deleteOrder(id);
        if(i>0){
            return R.ok().message("删除订单成功");
        }
        return R.error().message("删除订单失败");
    }

    @PostMapping("/updateDeleteStatus/{id}")
    public R updateDeleteStatus(@PathVariable("id") Long id){
        //逻辑删除
        int i = orderService.updateOrderDeleteStatus(id);
        if(i>0){
            return R.ok().message("状态更新成功");
        }
        return R.error().message("状态更新失败");
    }

}
