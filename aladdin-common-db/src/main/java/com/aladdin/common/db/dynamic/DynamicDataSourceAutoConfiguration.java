package com.aladdin.common.db.dynamic;

import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 动态数据源自动配置
 *
 * @author cles
 * @date 2026/05/06
 */
@Configuration
@ConditionalOnProperty(prefix = "aladdin.db.dynamic", name = "enabled", havingValue = "true")
public class DynamicDataSourceAutoConfiguration {

    @Bean
    public DynamicDataSourceInterceptor dynamicDataSourceInterceptor() {
        return new DynamicDataSourceInterceptor();
    }

    @Bean
    public Advisor dynamicDataSourceAdvisor() {
        AnnotationMatchingPointcut pointcut = new AnnotationMatchingPointcut(null, DS.class, true);
        return new DefaultPointcutAdvisor(pointcut, dynamicDataSourceInterceptor());
    }
}
