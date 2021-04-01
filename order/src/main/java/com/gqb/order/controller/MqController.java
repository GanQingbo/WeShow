package com.gqb.order.controller;

import com.gqb.common.utils.R;
import com.gqb.order.entity.Order;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author GanQingbo
 * @Classname MqController
 * @Description
 * @date 2021/3/13 11:44
 */
@RequestMapping("/mq")
@RestController
@CrossOrigin
public class MqController {
    @Resource
    RabbitTemplate rabbitTemplate;

    /**
     * 收到创建订单请求，放进队列中，createOrder接收消息创建订单
     * @return
     */
    @PostMapping("/secKill")
    public R createExchange(@RequestBody Order order){
        rabbitTemplate.convertAndSend("weshow-createOrder","order.create",order,new CorrelationData(UUID.randomUUID().toString()));
        return R.ok();
    }
}
