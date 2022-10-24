package com.aladdin.mis.common.redis.service;

/**
 * 用于测试的
 * @author cles
 */
public class HelloService {

    public final static HelloService me = new HelloService();

    public void index(){
        System.out.println("测试service");
    }
}
