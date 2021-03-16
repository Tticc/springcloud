package com.wenc.springcloud.payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping("/demo")
@Slf4j
@RestController
public class PaymentTestController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;


    @PostMapping(value = "/test")
    public String uploadExcel() {
        return "this is payment";
    }

    @GetMapping(value = "/list")
    public String getDis(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("serviceName:{}",service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                log.info("insId:{},\thost:{},\tport:{},\turi:{}",instance.getInstanceId(),instance.getHost(),instance.getPort(),instance.getUri());
            }
        }
        return "success";
    }


}
