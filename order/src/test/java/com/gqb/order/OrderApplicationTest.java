package com.gqb.order;

import com.gqb.order.entity.Order;
import com.rabbitmq.client.Channel;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.UUID;

/**
 * @author GanQingbo
 * @Classname OrderApplicationTest
 * @Description
 * @date 2021/3/13 10:38
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderApplicationTest {
    @Autowired
    AmqpAdmin amqpAdmin;

    /**
     * 创建Exchange
     */
    @Test
    public void createExchange(){
        //创建一个Direct类型交换机，参数说明：name:交换机名字，durable:是否持久化，autoDelete是否自动删除
        DirectExchange directExchange = new DirectExchange("direct-test",true,false);
        amqpAdmin.declareExchange(directExchange);
        System.out.println("direct-test创建成功");
    }

    /**
     * 创建Queue
     */
    @Test
    public void createQueue(){
        //参数说明：name名字，durable持久化,exclusive排他,autoDelete自动生成
        Queue queue = new Queue("hello-queue",true,false,false);
        amqpAdmin.declareQueue(queue);
        System.out.println("hello-queue创建成功");
    }

    /**
     * 将交换机与队列绑定
     */
    @Test
    public void createBinding(){
        //参数说明:destination目的地，destinationType目的地类型（可以跟交换机或队列绑定）,exchange交换机，routingKey路由键
        Binding binding = new Binding("hello-queue", Binding.DestinationType.QUEUE,"direct-test","hello.java",null);
        amqpAdmin.declareBinding(binding);
        System.out.println("binding成功");
    }

    @Resource
    RabbitTemplate rabbitTemplate;
    /**
     * 发送消息测试
     */
    @Test
    public void sentMessage(){
        //发送消息,参数说明：exchange，routingKey，object
        //发送出去的对象要实现序列化接口，发送的消息也可以以Json的格式发送,要写好配置类以及toString方法
        //用UUID生成唯一的消息id
        Order order = new Order();
        order.setId(112L);
        //order.setName("hello world");
        rabbitTemplate.convertAndSend("direct-test","hello.java",order,new CorrelationData(UUID.randomUUID().toString()));
        System.out.println("发送成功");
    }

    /**
     * 监听消息,queue声明需要监听的所有队列
     * Message来自amqp.core包,原生消息详细内容，头+体
     * T<发送消息的类型> Order order,收到的order会自动转换成order对象
     * Channel channel：当前传输数据的通道，可不写
     *
     * Queue可以很多人同时监听，只要收到消息队列就删除该信息，而且只能有一个收到此消息
     * 场景：
     *  1. 启动多个订单服务，同一个消息只能有一个客户端收到
     *  2. 处理业务期间不会接收消息，处理完了才会接收下一个消息
     */
    //@RabbitListener(queues = {"hello-queue"})
    public void receiveMessage(Message message, Order order, Channel channel){
        byte[] body = message.getBody();
        System.out.println("收到的消息message:"+order.toString());
        //channel内自增的tag
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            //确认消息，第二个参数为批量模式，false表示只确认当前的消息收到了
            channel.basicAck(deliveryTag,false);
            //拒绝消息,第二参数是批量模式，第三个参数是否重新入队，false表示丢弃，true重新入队
            channel.basicNack(deliveryTag,false,true);
        } catch (IOException e) {
            //网络异常
            e.printStackTrace();
        }
    }

    @Test
    public void createOrderTest(){
        Order order = new Order();
        order.setOrderSn("1123233");
        rabbitTemplate.convertAndSend("order-event-exchange","order.create",order);
    }

    //延时队列测试
/*    @Test
    @RabbitListener(queues = "order.release.queue")
    public void list(Order order,Channel channel,Message message){
        System.out.println("收到消息，准备关闭订单:"+order.getOrderSn());
        try{
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);

        }catch (Exception e){
            e.printStackTrace();
        }
    }*/
}
