package com.atguigu.springcloud.lb.impl;

import com.atguigu.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class MyLb implements LoadBalancer {

    private static final AtomicInteger integer=new AtomicInteger(0);

    private final int getAndIncrement(){
        int current,next;

        do{
             current = integer.get();
             next= current > Integer.MAX_VALUE ? 0:current+1;
        }while (! integer.compareAndSet(current,next));
        log.info("************* next  :"+next);
        return next;
    }

    @Override
    public ServiceInstance getServiceInstance(List<ServiceInstance> serviceInstanceList) {
        int index = getAndIncrement() % serviceInstanceList.size();
        return serviceInstanceList.get(index);
    }
}
