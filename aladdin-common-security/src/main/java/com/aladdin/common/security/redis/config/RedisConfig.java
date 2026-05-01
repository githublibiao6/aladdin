package com.aladdin.common.security.redis.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Redis配置
 *
 * @author cles
 * @date 2026/04/30
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(RedisConnectProperties.class)
@ConditionalOnProperty(prefix = "aladdin.security.redis", name = "enabled", havingValue = "true", matchIfMissing = true)
public class RedisConfig {

}
