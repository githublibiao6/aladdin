package com.aladdin.common.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 核心模块配置属性
 *
 * @author cles
 * @date 2026/04/30
 */
@Data
@ConfigurationProperties(prefix = "aladdin.core")
public class CoreProperties {

    private boolean corsEnabled = true;
    private boolean swaggerEnabled = true;
    private boolean repeatSubmitEnabled = false;
    private int repeatSubmitInterval = 1000;
}
