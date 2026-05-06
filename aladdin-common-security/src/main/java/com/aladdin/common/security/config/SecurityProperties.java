package com.aladdin.common.security.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 安全模块配置属性
 *
 * @author cles
 * @date 2026/05/06
 */
@Data
@ConfigurationProperties(prefix = "aladdin.security")
public class SecurityProperties {

    private boolean enabled = true;
    private Token token = new Token();
    private String[] whitelist = new String[0];
    private boolean operLogEnabled = true;

    @Data
    public static class Token {
        private String secret = "aladdin-platform-secret-key-2026";
        private long expireMinutes = 120;
        private String header = "Authorization";
        private String prefix = "Bearer ";
    }
}
