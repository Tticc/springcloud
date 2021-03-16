package com.wenc.springcloud.payment.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(
        name = "cloud-payment",
        url = "${ms-url.cloud-payment:}",
        path = "/feign/demo"
)
@Component
public interface DemoFeignClient {

    @PostMapping(value = "/test")
    String test();

}
