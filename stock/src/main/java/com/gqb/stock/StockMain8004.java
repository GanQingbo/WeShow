package com.gqb.stock;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author GanQingbo
 * @Classname StockMain8004
 * @Description
 * @date 2021/3/10 10:21
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableRabbit
@EnableFeignClients
public class StockMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(StockMain8004.class,args);
    }
}
