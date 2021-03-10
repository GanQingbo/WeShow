package com.gqb.order.controller;

import com.gqb.common.utils.R;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/createOrder")
    public R createOrder(){
        return null;
    }
}
