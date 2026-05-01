package com.aladdin.common.db.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 数据访问自动配置
 *
 * @author cles
 * @date 2026/04/30
 */
@Configuration
@ConditionalOnProperty(prefix = "aladdin.db", name = "enabled", havingValue = "true", matchIfMissing = true)
public class DbAutoConfiguration {

    @Bean
    public DbConfig dbConfig() {
        return new DbConfig();
    }
}
