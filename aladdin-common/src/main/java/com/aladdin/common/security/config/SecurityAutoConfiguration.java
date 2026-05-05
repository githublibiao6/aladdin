package com.aladdin.common.security.config;

import com.aladdin.common.security.filter.SsoAuthFilter;
import com.aladdin.common.security.filter.SsoLoginFilter;
import com.aladdin.common.security.log.LoginLogService;
import com.aladdin.common.security.log.OperationLogService;
import com.aladdin.common.security.log.aspect.OperationLogAspect;
import com.aladdin.common.security.log.impl.RedisLoginLogServiceImpl;
import com.aladdin.common.security.log.impl.RedisOperationLogServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ConditionalOnProperty(prefix = "aladdin.security", name = "enabled", havingValue = "true", matchIfMissing = true)
@Import(SecurityProperties.class)
public class SecurityAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(LoginLogService.class)
    public LoginLogService loginLogService() {
        return new RedisLoginLogServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean(OperationLogService.class)
    public OperationLogService operationLogService() {
        return new RedisOperationLogServiceImpl();
    }

    @Bean
    @ConditionalOnProperty(prefix = "aladdin.security", name = "operation-log-enabled", havingValue = "true", matchIfMissing = true)
    public OperationLogAspect operationLogAspect(OperationLogService operationLogService) {
        OperationLogAspect aspect = new OperationLogAspect();
        aspect.setOperationLogService(operationLogService);
        return aspect;
    }

    @Bean
    @ConditionalOnProperty(prefix = "aladdin.security", name = "filter-enabled", havingValue = "true", matchIfMissing = false)
    public FilterRegistrationBean<SsoLoginFilter> ssoLoginFilterRegistration(SecurityProperties securityProperties) {
        FilterRegistrationBean<SsoLoginFilter> registration = new FilterRegistrationBean<>();
        SsoLoginFilter filter = new SsoLoginFilter();
        filter.setWhitelist(securityProperties.getWhitelist());
        registration.setFilter(filter);
        registration.addUrlPatterns("/*");
        registration.setName("ssoLoginFilter");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    @ConditionalOnProperty(prefix = "aladdin.security", name = "filter-enabled", havingValue = "true", matchIfMissing = false)
    public FilterRegistrationBean<SsoAuthFilter> ssoAuthFilterRegistration() {
        FilterRegistrationBean<SsoAuthFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new SsoAuthFilter());
        registration.addUrlPatterns("/*");
        registration.setName("ssoAuthFilter");
        registration.setOrder(2);
        return registration;
    }
}
