package com.gqb.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author GanQingbo
 * @Classname OrderMain8002
 * @Description
 * @date 2021/3/9 21:16
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class OrderMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain8002.class,args);
    }
}
