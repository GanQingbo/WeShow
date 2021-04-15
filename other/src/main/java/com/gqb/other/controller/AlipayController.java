package com.gqb.other.controller;

import com.gqb.common.utils.R;
import com.gqb.other.entity.Order;
import com.gqb.other.service.AlipayService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author GanQingbo
 * @Classname AlipayController
 * @Description
 * @date 2021/4/16 0:32
 */
@RestController
@RequestMapping("/other/alipay")
public class AlipayController {
    @Resource
    AlipayService alipayService;

    @PostMapping("/alipay")
    public R alipay(@RequestBody Order order){
        String s = alipayService.alipay(order);
        return R.ok().data("body",s);
    }
}
