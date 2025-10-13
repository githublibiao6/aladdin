package com.aladdin.mis.base.config;

import com.aladdin.mis.base.service.PersonService;
import com.aladdin.mis.base.service.impl.PersonServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 测试加载
 */
@Configuration
public class BaseAutoConfiguration {

    @Bean
    public PersonService testService() {
        return new PersonServiceImpl();
    }
}
