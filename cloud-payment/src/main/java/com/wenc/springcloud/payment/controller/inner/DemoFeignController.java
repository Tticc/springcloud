package com.wenc.springcloud.payment.controller.inner;

import com.wenc.springcloud.payment.feign.DemoFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/feign/demo")
@Slf4j
@RestController
public class DemoFeignController implements DemoFeignClient {

    private String baseUrl = "http://CLOUD-PAYMENT";


    @PostMapping(value = "/test")
    public String test() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String body = "body";
        return "success。 feign return is: "+body;
    }

}

