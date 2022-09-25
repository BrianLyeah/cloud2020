package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceFallback implements OrderService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "OrderServiceFallback paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "OrderServiceFallback paymentInfo_TimeOut";
    }
}
