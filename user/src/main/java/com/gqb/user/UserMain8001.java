package com.gqb.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author GanQingbo
 * @Classname UserMain8001
 * @Description
 * @date 2021/3/3 0:08
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class UserMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(UserMain8001.class,args);
    }
}
