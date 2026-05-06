package com.aladdin.common.core.web;

import com.aladdin.common.core.config.CoreProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;
import java.util.HashMap;
import java.util.Map;

/**
 * XSS防护配置
 *
 * @author cles
 * @date 2026/05/06
 */
@Configuration
@ConditionalOnProperty(prefix = "aladdin.core.xss", name = "enabled", havingValue = "true", matchIfMissing = true)
public class XssFilterConfig {

    @Bean
    public FilterRegistrationBean<XssFilter> xssFilterRegistration(CoreProperties coreProperties) {
        FilterRegistrationBean<XssFilter> registration = new FilterRegistrationBean<>();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new XssFilter());
        registration.addUrlPatterns("/*");
        registration.setOrder(1);
        Map<String, String> initParams = new HashMap<>();
        String excludes = coreProperties.getXssExcludes();
        if (excludes != null) {
            initParams.put("excludes", excludes);
        }
        registration.setInitParameters(initParams);
        return registration;
    }
}
