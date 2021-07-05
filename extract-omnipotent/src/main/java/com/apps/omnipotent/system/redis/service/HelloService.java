package com.apps.omnipotent.system.redis.service;

public class HelloService {
    public final static HelloService me = new HelloService();

    public void index(){
        System.out.println("测试service");
    }
}
