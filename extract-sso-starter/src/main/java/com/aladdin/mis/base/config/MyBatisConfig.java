package com.aladdin.mis.base.config;

import com.aladdin.mis.base.interceptor.BaseModelHandleInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisConfig {

    @Bean
    public BaseModelHandleInterceptor entityInsertInterceptor() {
        return new BaseModelHandleInterceptor();
    }
}
