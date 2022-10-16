package com.atguigu.springcloud.alibaba.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.alibaba.service.impl.PaymentFallbackServiceImpl;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackServiceImpl.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
//    @SentinelResource(value = "",fallbackClass = PaymentFallbackServiceImpl.class,fallback = "paymentSQL")
    public CommonResult<Payment> paymentSQL(@PathVariable("id")Long id);
}
