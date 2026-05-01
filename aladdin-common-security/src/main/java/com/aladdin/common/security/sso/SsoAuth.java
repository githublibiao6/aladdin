package com.aladdin.common.security.sso;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * SSO认证配置
 *
 * @author cles
 * @date 2026/04/30
 */
@Configuration
@ConfigurationProperties(prefix = "aladdin.security.sso")
public class SsoAuth {

    private boolean enable;

    private String url;

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isEnable() {
        return enable;
    }

    public String getUrl() {
        return url;
    }

    public static void verifyLogin(String token) {
    }

    public static void verifyAuth(String token) {
    }
}
