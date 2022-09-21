package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FeignConfig {

    @Bean
    Logger.Level getFeignLog(){
        return Logger.Level.FULL;
    }

}
