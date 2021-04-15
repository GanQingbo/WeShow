package com.gqb.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * @author GanQingbo
 * @Classname AuthMain8006
 * @Description
 * @date 2021/4/13 14:20
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients

public class AuthMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(AuthMain8006.class,args);
    }
}
