package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.alibaba.blockHandler.GloableBlockHandler;
import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowController {


    @GetMapping(value = "/flow/limit1")
    @SentinelResource(value = "limit1",blockHandlerClass = GloableBlockHandler.class,blockHandler = "limit1Handler")
    public CommonResult limit1(@RequestParam(value = "p1",required = false)String p1)
    {
        return new CommonResult(200,"flow limit1"+p1+"---1111111");
    }

    @GetMapping(value = "/flow/limit2")
    @SentinelResource(value = "limit2",blockHandlerClass = GloableBlockHandler.class,blockHandler = "limit2Handler")
    public CommonResult limit2()
    {
        return new CommonResult(200,"flow limit1-----222222");
    }

}
