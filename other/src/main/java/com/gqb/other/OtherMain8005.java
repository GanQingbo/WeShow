package com.gqb.other;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author GanQingbo
 * @Classname OtherMain8005
 * @Description
 * @date 2021/3/7 16:31
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OtherMain8005 {
    public static void main(String[] args) {
        SpringApplication.run(OtherMain8005.class,args);
    }
}