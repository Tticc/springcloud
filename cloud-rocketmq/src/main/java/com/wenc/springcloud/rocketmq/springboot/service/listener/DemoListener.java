package com.wenc.springcloud.rocketmq.springboot.service.listener;

import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;


@Component
@RocketMQMessageListener(consumerGroup = "demoListenerGroup", topic = "TestTopic", consumeMode = ConsumeMode.CONCURRENTLY)
public class DemoListener implements RocketMQListener<String> {
    public void onMessage(String message) {
        System.out.println("receive! message is:"+message);
    }
}
