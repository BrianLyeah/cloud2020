package com.atguigu.springcloud.service;

import org.springframework.messaging.Message;

public interface IReceiveMessageService {

    void receiveMessage(Message<String> message);


}
