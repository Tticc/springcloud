package com.wenc.springcloud.rocketmq.springboot.service.producer;

import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class RocketMQProducerManager {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Value("${rocketmq.producer.group}")
    private String producerGroup;

    public String sendMessage(String topic,String msg){
        this.rocketMQTemplate.convertAndSend(topic,msg);
        return "success";
    }
    public String sendMessageInTransaction(String topic,String msg){
        String[] tags = new String[]{"TagA","TagB","TagC","TagD","TagE"};
        for (int i = 0; i < 10; i++) {
            String tag = tags[i%tags.length];
            Message<String> message = MessageBuilder.withPayload(tag+"_"+msg)
                    .setHeader(RocketMQHeaders.TRANSACTION_ID,"TransID"+i)
                    .setHeader("myCusHeaderProp","hello_"+i)
                    .build();
            String destination = topic+":"+tag;
            TransactionSendResult transactionSendResult = rocketMQTemplate.sendMessageInTransaction(null, destination, message, destination);

            System.out.println("send result:" + transactionSendResult);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "success";
    }

}
