package com.aladdin.common.core.config;

import com.aladdin.common.core.exception.GlobalExceptionHandler;
import com.aladdin.common.core.utils.SpringContextUtil;
import com.aladdin.common.core.web.CorsConfig;
import com.aladdin.common.core.web.JacksonConfig;
import com.aladdin.common.core.web.ResponseAdvice;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 核心模块自动配置
 *
 * @author cles
 * @date 2026/04/30
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
public class CoreAutoConfiguration {

    @Bean
    public CoreProperties coreProperties() {
        return new CoreProperties();
    }
}
