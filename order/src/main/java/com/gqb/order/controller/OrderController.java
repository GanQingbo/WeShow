package com.gqb.order.controller;

import com.gqb.common.utils.R;
import com.gqb.order.client.StockClient;
import com.gqb.order.entity.Order;
import com.gqb.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

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

    @PostMapping("/createOrder")
    public R createOrder(@RequestBody Order order){
        int i = orderService.createOrder(order);
        if(i>0){
            return R.ok().data("order",order);
        }
        return R.error().message("创建订单失败");
    }

    @PostMapping("/seckill")
    public R createMuchOrder(){

        return R.ok();
    }
}
