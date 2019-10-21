package com.company.system.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

@Service
public class MessageProducerTest {

//    @Resource(name="amqpTemplate")
    private AmqpTemplate  amqpTemplate;

    public void sendMessage(Object message)throws IOException {
        amqpTemplate.convertAndSend("queueTestKey", message);//blog.csdn.net/weixin_39220472/article/details/82953759
    }
}
