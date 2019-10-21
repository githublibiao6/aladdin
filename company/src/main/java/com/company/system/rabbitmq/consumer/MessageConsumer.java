package com.company.system.rabbitmq.consumer;


import java.io.UnsupportedEncodingException;
import java.util.Date;

import com.company.system.interceptor.bean.VisitLog;
import com.company.system.interceptor.dao.VisitLogDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;



public class MessageConsumer implements MessageListener {
    private Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @Autowired
    private VisitLogDao visitLogDao;

    public void onMessage(Message message) {
        try {
            String messages = new String(message.getBody(), "UTF-8");
            String[] str = messages.split(",");
            VisitLog log = new VisitLog();
            log.setId(Integer.valueOf(str[0]));
            log.setIp(str[1]);
            log.setUrl(str[2]);
            log.setTime(Long.valueOf(str[3]));
            log.setDate(new Date());
            System.out.println("log-->" + log.toString());
            visitLogDao.insertLog(log);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.info("consumer receive message------->:{}", message);
    }
}