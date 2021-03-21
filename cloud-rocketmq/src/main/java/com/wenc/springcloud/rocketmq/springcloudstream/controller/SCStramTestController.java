//package com.wenc.springcloud.rocketmq.springcloudstream.controller;
//
//import com.wenc.springcloud.rocketmq.springcloudstream.service.producer.ScStreamProducer;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * 使用失败
// */
//@RequestMapping("/scs/demo")
//@Slf4j
//@RestController
//public class SCStramTestController {
//
//    @Autowired
//    private ScStreamProducer scStreamProducer;
//
//    @PostMapping(value = "/send")
//    public String send() {
//        return scStreamProducer.sendMessage("message");
//    }
//
//
//
//}
