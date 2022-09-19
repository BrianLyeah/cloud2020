package com.atguigu.myrules;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySafeRule {

    @Bean
    public IRule getRandomRule(){
        return new RandomRule();
    }
}
