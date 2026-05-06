package com.aladdin.common.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 核心模块配置属性
 *
 * @author cles
 * @date 2026/05/06
 */
@Data
@ConfigurationProperties(prefix = "aladdin.core")
public class CoreProperties {

    private boolean corsEnabled = true;
    private boolean swaggerEnabled = true;
    private boolean repeatSubmitEnabled = false;
    private int repeatSubmitInterval = 1000;
    private Xss xss = new Xss();
    private TraceId traceId = new TraceId();
    private RateLimitConfig rateLimit = new RateLimitConfig();

    @Data
    public static class Xss {
        private boolean enabled = true;
        private String excludes = "";
    }

    public String getXssExcludes() {
        return xss.getExcludes();
    }

    @Data
    public static class TraceId {
        private boolean enabled = true;
    }

    @Data
    public static class RateLimitConfig {
        private boolean enabled = true;
    }
}
