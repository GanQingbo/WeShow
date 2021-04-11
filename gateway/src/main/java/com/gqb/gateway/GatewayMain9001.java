package com.gqb.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: WeShow
 * @description: gateway 启动类
 * @author: Gan
 * @date: 2021-04-08 21:09
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9001.class,args);
    }
}
