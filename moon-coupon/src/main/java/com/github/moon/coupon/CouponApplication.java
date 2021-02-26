package com.github.moon.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author aqiang9  2020-07-27
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CouponApplication {
    public static void main(String[] args){
        SpringApplication.run(CouponApplication.class,args) ;
    }
}