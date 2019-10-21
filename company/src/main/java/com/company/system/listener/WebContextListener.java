package com.company.system.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
//@Service
//public class WebContextListener implements ApplicationListener<ContextRefreshedEvent>  {
public class WebContextListener{
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (contextRefreshedEvent.getApplicationContext().getParent() == null) {//保证只执行一次
            System.err.println("1111111111111111111111111111111111111111111111111111");
        }
    }
}
