package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    public static final String INVOKE_URL="http://cloud-provider-payment";

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/zk")
    public CommonResult getConsumerZk(){

        String str = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return new CommonResult(200,"server msg :"+serverPort,str);
    }

}
