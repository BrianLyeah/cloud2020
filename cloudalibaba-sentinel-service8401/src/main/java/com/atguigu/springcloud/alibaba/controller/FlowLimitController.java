package com.atguigu.springcloud.alibaba.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sun.deploy.security.BlockedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
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

    @GetMapping("/testHostKey")
    @SentinelResource(value = "testHostKey",blockHandler = "hostKeyBlockHandler")
    public String testHostKey(@RequestParam(value = "p1",required = false)String p1,@RequestParam(value = "p2",required = false)String p2) {
        return "------hostKey  "+ UUID.randomUUID();
    }

    public String hostKeyBlockHandler(String p1, String p2, BlockException exp)
    {
        exp.printStackTrace();
        return p1+"----"+p2+"------hostKeyBlockHandler 哭哭哭";
    }


}
