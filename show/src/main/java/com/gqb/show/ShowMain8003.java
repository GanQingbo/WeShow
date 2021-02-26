package com.gqb.show;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author GanQingbo
 * @Classname ShowMian8003
 * @Description
 * @date 2021/2/25 12:38
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ShowMain8003 {
    public static void main(String[] args) {
        SpringApplication.run(ShowMain8003.class,args);
    }
}
