package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IReceiveMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@EnableBinding(Sink.class)
public class ReceiveMessageServiceImpl implements IReceiveMessageService {

    @Value("${server.port}")
    private String serverPort;

    @Override
    @StreamListener(Sink.INPUT)
    public void receiveMessage(Message<String> message) {
        System.out.println("消费者1号，接收到消息："+message.getPayload()+"\t"+serverPort);
    }
}
