package com.atguigu.springcloud.alibaba.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class FlowLimitController
{
    @GetMapping("/testA")
    public String testA() {
        return "------testA  "+ UUID.randomUUID();
    }

    @GetMapping("/testB")
    public String testB() {
        return "------testB  "+ UUID.randomUUID();
    }

    @GetMapping("/testD")
    public String testD() {

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        int i = 1/0;
        return "------testD  "+ UUID.randomUUID();
    }



}
