package com.gqb.stock.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author GanQingbo
 * @Classname MyRabbitConfig
 * @Description 把消息转换成Json的格式
 * @date 2021/3/13 20:12
 */
@Configuration
public class MyRabbitConfig {
    /**
     * 使用JSON序列化机制，进行消息转换
     */
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Exchange stockEventExchange(){
        TopicExchange exchange = new TopicExchange("stock-event-exchange",true,false);
        return exchange;
    }

    @Bean
    public Queue stockReleaseQueue(){
        return new Queue("stock.release.queue",true,false,false,null);
    }

    @Bean
    public Queue stockDelayQueue(){
        Map<String,Object> args=new HashMap<>();
        args.put("x-dead-letter-exchange","stock-event-exchange");
        args.put("x-dead-letter-routing-key","stock.release");
        args.put("x-message-ttl",60000);
        return new Queue("stock.delay.queue",true,false,false,args);
    }

    @Bean
    public Binding stockReleaseBinding(){
        Binding binding = new Binding("stock.release.queue", Binding.DestinationType.QUEUE, "stock-event-exchange", "stock.release.#", null);
        return binding;
    }

    /**
     * 消息发送到这个队列里去
     * @return
     */
    @Bean
    public Binding stockLockedBinding(){
        Binding binding = new Binding("stock.delay.queue", Binding.DestinationType.QUEUE, "stock-event-exchange", "stock.locked.#", null);
        return binding;
    }

    /**
     * 定制RabbitTemplate
     */
    @Resource
    RabbitTemplate rabbitTemplate;
    @PostConstruct //MyRabbitConfig对象创建完成以后，执行这个方法
    public void initRabbitTemplate(){
        //设置确认回调
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            /**
             * @param correlationData 当前消息的唯一关联数据（消息的唯一id）
             * @param b 消息是否成功收到
             * @param s 失败的原因
             */
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                System.out.println("CorrelationData:"+correlationData+" ack:"+b);
            }
        });

        //设置消息抵达队列的确认回调
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            /**
             * 只要消息没有投递给指定的队列，就触发这个失败回调
             * @param message 投递失败的消息详细信息
             * @param i 回复的状态码
             * @param s 回复的文本内容
             * @param s1 当时这个消息发给哪个交换机
             * @param s2 当时发送消息时的路由键
             */
            @Override
            public void returnedMessage(Message message, int i, String s, String s1, String s2) {
                System.out.println("message:"+message+" 交换机："+s1);
            }
        });
    }
}
