package com.aladdin.common.security.config;

import com.aladdin.common.security.filter.AuthFilter;
import com.aladdin.common.security.filter.LoginFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 安全模块自动配置
 *
 * @author cles
 * @date 2026/04/30
 */
@Configuration
@ConditionalOnProperty(prefix = "aladdin.security", name = "enabled", havingValue = "true", matchIfMissing = true)
public class SecurityAutoConfiguration {

    @Bean
    public FilterRegistrationBean<LoginFilter> loginFilterRegistration() {
        FilterRegistrationBean<LoginFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new LoginFilter());
        registration.addUrlPatterns("/*");
        registration.setName("loginFilter");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean<AuthFilter> authFilterRegistration() {
        FilterRegistrationBean<AuthFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new AuthFilter());
        registration.addUrlPatterns("/*");
        registration.setName("authFilter");
        registration.setOrder(2);
        return registration;
    }

    @Bean
    public SecurityProperties securityProperties() {
        return new SecurityProperties();
    }
}
