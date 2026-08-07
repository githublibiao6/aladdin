package com.aladdin.common.security.config;

import com.aladdin.common.security.handler.SecurityExceptionHandler;
import com.aladdin.common.security.log.LoginLogService;
import com.aladdin.common.security.log.OperationLogService;
import com.aladdin.common.security.log.aspect.OperationLogAspect;
import com.aladdin.common.security.log.impl.RedisLoginLogServiceImpl;
import com.aladdin.common.security.log.impl.RedisOperationLogServiceImpl;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
@ConditionalOnProperty(prefix = "aladdin.security", name = "enabled", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(SecurityProperties.class)
@Import({
        SecurityConfig.class,
        SecurityExceptionHandler.class
})
public class SecurityAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(LoginLogService.class)
    @ConditionalOnProperty(prefix = "aladdin.security", name = "redis-enabled", havingValue = "true", matchIfMissing = true)
    public LoginLogService loginLogService(StringRedisTemplate redisTemplate) {
        return new RedisLoginLogServiceImpl(redisTemplate);
    }

    @Bean
    @ConditionalOnMissingBean(OperationLogService.class)
    @ConditionalOnProperty(prefix = "aladdin.security", name = "redis-enabled", havingValue = "true", matchIfMissing = true)
    public OperationLogService operationLogService(StringRedisTemplate redisTemplate) {
        return new RedisOperationLogServiceImpl(redisTemplate);
    }

    @Bean
    @ConditionalOnProperty(prefix = "aladdin.security", name = "oper-log-enabled", havingValue = "true", matchIfMissing = true)
    public OperationLogAspect operationLogAspect(OperationLogService operationLogService) {
        OperationLogAspect aspect = new OperationLogAspect();
        aspect.setOperationLogService(operationLogService);
        return aspect;
    }

    /**
     * 注册 BeanPostProcessor，将 MethodSecurityInterceptor 的 AccessDecisionManager
     * 替换为 AdminAwareAccessDecisionManager，使 admin 用户绕过所有 @PreAuthorize 校验。
     * 必须声明为 static，避免 Spring 提前实例化本配置类导致 @ConditionalOnBean 失效。
     */
    @Bean
    public static BeanPostProcessor methodSecurityInterceptorPostProcessor() {
        return new MethodSecurityInterceptorPostProcessor();
    }
}
