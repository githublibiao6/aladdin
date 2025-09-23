package com.aladdin.mis.common.license.user;
/*
 *  Created by cles on 2024/8/18 17:37
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author cles
 * @description: 注册拦截器
 * @Date 2024/8/18 17:37
 * @version: 1.0.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 请求会先进这里
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LicenseCheckInterceptor());
    }
}

