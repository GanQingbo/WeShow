package com.gqb.order.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


/**
 * @program: WeShow
 * @description: 队列，交换机相关
 * @author: Gan
 * @date: 2021-04-21 10:13
 **/
@Configuration
public class MQConfig {
    //Rabbitmq 中没有的会自动创建
    @Bean
    public Queue orderDelayQueue(){
        Map<String,Object> args=new HashMap<>();
        args.put("x-dead-letter-exchange","order-event-exchange");
        args.put("x-dead-letter-routing-key","order.release");
        //设置过期时间一分钟
        args.put("x-message-ttl",60000);
        Queue queue = new Queue("order.delay.queue", true, false, false,args);
        return queue;
    }
    @Bean
    public Queue orderReleaseQueue(){
        Queue queue = new Queue("order.release.queue", true, false, false);
        return queue;
    }
    @Bean
    public Exchange orderEventExchange(){
        TopicExchange exchange = new TopicExchange("order-event-exchange", true, false);
        return exchange;
    }
    @Bean
    public Binding orderCreateBinding(){
        Binding binding = new Binding("order.delay.queue", Binding.DestinationType.QUEUE, "order-event-exchange", "order.create", null);
        return binding;
    }
    @Bean
    public Binding orderReleaseBinding(){
        Binding binding = new Binding("order.release.queue", Binding.DestinationType.QUEUE, "order-event-exchange", "order.release", null);
        return binding;
    }
}
