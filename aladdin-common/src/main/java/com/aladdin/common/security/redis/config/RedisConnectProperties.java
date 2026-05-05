package com.aladdin.common.security.redis.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Redis连接信息
 *
 * @author cles
 * @date 2026/04/30
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConnectProperties {

    private String host;

    private int port;

    private String password;

    private int database;
}
