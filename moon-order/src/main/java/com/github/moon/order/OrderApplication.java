package com.github.moon.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: wsg
 * @Date: 2021/02/24/21:40
 * @Description:
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderApplication {
        public static void main(String[] args){
            SpringApplication.run(OrderApplication.class,args) ;
        }
    }
