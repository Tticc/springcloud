package com.wenc.springcloud.payment.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLogConfig {

    @Bean
    public Logger.Level getLoggerLevel(){
        return Logger.Level.FULL;
    }
}
