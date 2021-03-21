package com.wenc.springcloud.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

/**
 * 2021-3-9 21:23:38
 */

// spring-cloud-steam 尝试失败
//@EnableBinding({Source.class, Sink.class})
@SpringBootApplication
public class CloudRocketMQApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudRocketMQApplication.class, args);
    }
}
