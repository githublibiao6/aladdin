package com.aladdin.mis.base.config;

import com.aladdin.mis.base.interceptor.BaseModelQueryHandleInterceptor;
import com.aladdin.mis.base.interceptor.BaseModelUpdateHandleInterceptor;
import com.aladdin.mis.base.interceptor.BaseSqlLogInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisConfig {

    @Bean
    public BaseModelUpdateHandleInterceptor entityUpdateInterceptor() {
        return new BaseModelUpdateHandleInterceptor();
    }

    @Bean
    public BaseModelQueryHandleInterceptor entityQueryInterceptor() {
        return new BaseModelQueryHandleInterceptor();
    }

    @Bean
    public BaseSqlLogInterceptor baseSqlLogInterceptor() {
        return new BaseSqlLogInterceptor();
    }
}
