package com.wenc.springcloud.order.controller;

import com.wenc.springcloud.payment.feign.DemoFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RequestMapping("/demo")
@Slf4j
@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    private String baseUrl = "http://CLOUD-PAYMENT";

    @Resource
    private DemoFeignClient demoFeignClient;


    @PostMapping(value = "/test")
    public String uploadExcel() {
        String url = baseUrl+"/demo/test";
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url, null, String.class);
        String body = stringResponseEntity.getBody();
        return "success。return data is: "+body;
    }

    @PostMapping(value = "/testFeign")
    public String testFeign(){
        String test = demoFeignClient.test();
        return test;
    }
}
