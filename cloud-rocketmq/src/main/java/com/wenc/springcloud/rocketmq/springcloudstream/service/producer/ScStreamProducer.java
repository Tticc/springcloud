//package com.wenc.springcloud.rocketmq.springcloudstream.service.producer;
//
//
//import org.apache.rocketmq.common.message.MessageConst;
//import org.springframework.cloud.stream.messaging.Source;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageHeaders;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class ScStreamProducer {
//    @Resource
//    private Source source;
//
//    public String sendMessage(String msg){
//        Map<String,Object> headers = new HashMap<>();
//        headers.put(MessageConst.PROPERTY_TAGS,"testTags");
//        MessageHeaders messageHeaders = new MessageHeaders(headers);
//        Message<String> message = MessageBuilder.createMessage(msg,messageHeaders);
//        boolean send = this.source.output().send(message);
//
//        return "success";
//    }
//}
