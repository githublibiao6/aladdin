package com.aladdin.common.security.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 全局安全配置
 *
 * @author cles
 * @date 2026/04/30
 */
@Component
@Data
@ConfigurationProperties(prefix = "aladdin.security")
public class SecurityProperties {

    private boolean enabled = true;

    private boolean verifyEnable = false;

    private boolean verifyCode = false;

    private boolean verifySms = false;
}
