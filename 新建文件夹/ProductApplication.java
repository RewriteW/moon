package com.github.moon.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author aqiang9  2020-07-27
 */
@EnableFeignClients(basePackages = "com.github.moon.*.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class ProductApplication {
    public static void main(String[] args){
        SpringApplication.run(ProductApplication.class,args) ;
    }
}