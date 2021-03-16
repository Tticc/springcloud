package com.wenc.springcloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 2021-3-8 23:03:26
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.wenc.springcloud"})
public class CloudPaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudPaymentApplication.class, args);
    }
}
