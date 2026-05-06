package com.aladdin.common.core.config;

import com.aladdin.common.core.exception.GlobalExceptionHandler;
import com.aladdin.common.core.utils.SpringContextUtil;
import com.aladdin.common.core.web.CorsConfig;
import com.aladdin.common.core.web.JacksonConfig;
import com.aladdin.common.core.web.ResponseAdvice;
import com.aladdin.common.core.web.TraceIdInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 核心模块自动配置
 *
 * @author cles
 * @date 2026/05/06
 */
@Configuration
@EnableConfigurationProperties(CoreProperties.class)
@Import({
        CorsConfig.class,
        JacksonConfig.class,
        GlobalExceptionHandler.class,
        ResponseAdvice.class,
        SpringContextUtil.class
})
public class CoreAutoConfiguration implements WebMvcConfigurer {

    private final CoreProperties coreProperties;

    public CoreAutoConfiguration(CoreProperties coreProperties) {
        this.coreProperties = coreProperties;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        if (coreProperties.getTraceId().isEnabled()) {
            registry.addInterceptor(traceIdInterceptor()).addPathPatterns("/**");
        }
        if (coreProperties.isRepeatSubmitEnabled()) {
            registry.addInterceptor(repeatSubmitInterceptor()).addPathPatterns("/**");
        }
    }

    @Bean
    @ConditionalOnProperty(prefix = "aladdin.core.trace-id", name = "enabled", havingValue = "true", matchIfMissing = true)
    public TraceIdInterceptor traceIdInterceptor() {
        return new TraceIdInterceptor();
    }

    @Bean
    @ConditionalOnProperty(prefix = "aladdin.core.repeat-submit", name = "enabled", havingValue = "true")
    public com.aladdin.common.core.web.RepeatSubmitInterceptor repeatSubmitInterceptor() {
        return new com.aladdin.common.core.web.RepeatSubmitInterceptor(coreProperties);
    }
}
