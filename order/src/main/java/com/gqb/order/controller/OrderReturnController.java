package com.gqb.order.controller;

import com.github.pagehelper.PageInfo;
import com.gqb.common.utils.R;
import com.gqb.order.entity.OrderReturn;
import com.gqb.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: WeShow
 * @description: 退票相关
 * @author: Gan
 * @date: 2021-03-18 22:06
 **/
@RestController
@RequestMapping("/order")
public class OrderReturnController {
    @Resource
    OrderService orderService;

    @PostMapping("/createOrderReturn")
    public R createReturn(@RequestBody OrderReturn orderReturn){
        int i = orderService.createOrderReturn(orderReturn);
        if(i>0){
            return R.ok();
        }
        return R.error();
    }

    @PostMapping("/getAllOrderReturn/{page}/{size}")
    public R getAllOrderReturn(@PathVariable("page") Integer page,@PathVariable("size") Integer size,@RequestBody OrderReturn orderReturn){
        PageInfo<OrderReturn> query = orderService.getOrderReturnQuery(page, size, orderReturn);
        return R.ok().data("orderReturn",query);
    }

    @PostMapping("/updateOrderReturn")
    public R updateOrderReturn(@RequestBody OrderReturn orderReturn){
        int i = orderService.updateOrderReturn(orderReturn);
        if(i>0){
            return R.ok();
        }
        return R.error();
    }
}
