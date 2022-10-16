package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.service.PaymentService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackServiceImpl implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(4001,"feign 服务降级 PaymentFallbackServiceImpl paymentSQL", new Payment(id,null));
    }
}
