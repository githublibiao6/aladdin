package com.company.system.dubbo.service;

import org.springframework.stereotype.Service;

/**
 * dubbo测试 service
 * @author lb
 *
 */
@Service
public interface DubboService {

    String sayHello(String name);
    
}
