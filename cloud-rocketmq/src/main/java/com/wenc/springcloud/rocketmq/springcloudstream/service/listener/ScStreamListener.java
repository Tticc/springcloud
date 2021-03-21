//package com.wenc.springcloud.rocketmq.springcloudstream.service.listener;
//
//
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.cloud.stream.messaging.Sink;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ScStreamListener {
//
//    // 暂时不知道第一个注解能不能用！！！ 2021-3-21 23:31:17
////    @StreamListener(value = Sink.INPUT,condition = "headers[RocketMQHeaders.PREFIX+RocketMQHeaders.TAGS]==testTag")
//    @StreamListener(value = Sink.INPUT)
//    public void onMessage(String msg){
//        System.out.println("receive message:"+msg+". from binding: "+Sink.INPUT);
//    }
//}
