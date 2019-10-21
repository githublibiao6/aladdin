package com.company.system.dubbo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * admin controller
 * @author lb
 * @date 2018年6月5日 下午8:56:11
 */
@RequestMapping("admin")
@Controller
public class DubboController {
    
//    @Resource
//    DubboService service;
    
//    public static void main(String[] args) throws Exception {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "consumer.xml" });
//        context.start();
//        DubboService dubboService = (DubboService)context.getBean("dubboService"); // 获取远程服务代理
//        String hello = dubboService.sayHello("  dubbo "); // 执行远程方法
//        context.close();
//        System.out.println(hello);
//    }
}
