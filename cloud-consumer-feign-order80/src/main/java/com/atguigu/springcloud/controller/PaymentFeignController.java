package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentFeignController {

    @Autowired
    PaymentFeignService paymentFeignService;


    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") String id){
        return paymentFeignService.getPaymentById(id);
    }

    @PostMapping(value = "consumer/payment/create")
    public CommonResult create(Payment payment){
        return paymentFeignService.create(payment);
    }

    @GetMapping(value = "consumer/payment/timeout")
    public String timeout(Payment payment){
        return paymentFeignService.timeout();
    }

}
