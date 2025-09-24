package com.aladdin.mis.base.config;

import com.aladdin.mis.base.service.TestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 测试加载
 */
@Configuration
public class BaseAutoConfiguration {

    @Bean
    public TestService  testService() {
        return new TestService();
    }
}
