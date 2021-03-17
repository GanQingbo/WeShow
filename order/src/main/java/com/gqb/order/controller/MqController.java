package com.gqb.order.controller;

import com.gqb.common.utils.R;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author GanQingbo
 * @Classname MqController
 * @Description
 * @date 2021/3/13 11:44
 */
@RequestMapping("/test")
@RestController
public class MqController {
    @Resource
    AmqpAdmin amqpAdmin;

    @GetMapping("/mq")
    public R createExchange(){
        //创建一个Direct类型交换机，参数说明：name:交换机名字，durable:是否持久化，autoDelete是否自动删除
        DirectExchange directExchange = new DirectExchange("direct-test",true,false);
        amqpAdmin.declareExchange(directExchange);
        System.out.println("direct-test创建成功");
        return R.ok().message("direct-test创建成功");
    }
}
