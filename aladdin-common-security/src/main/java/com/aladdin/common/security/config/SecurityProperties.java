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
    private Password password = new Password();
    private IpList ipList = new IpList();
    private Tenant tenant = new Tenant();

    @Data
    public static class Token {
        private String secret = "aladdin-platform-secret-key-2026";
        private long expireMinutes = 120;
        private String header = "Authorization";
        private String prefix = "Bearer ";
    }

    /**
     * 密码策略配置
     * enabled: 是否启用密码策略
     * defaultPassword: 新用户/重置时的默认密码
     * maxRetryCount: 允许输错次数，超过后锁定账号
     * lockDurationMinutes: 锁定时长（分钟）
     * forceChangeOnFirstLogin: 是否强制首次登录修改密码
     * expireDays: 密码过期天数，0表示不过期
     * historyCount: 密码历史记录数，新密码不能与最近N次相同
     */
    @Data
    public static class Password {
        private boolean enabled = true;
        private String defaultPassword = "123456";
        private int maxRetryCount = 5;
        private int lockDurationMinutes = 30;
        private boolean forceChangeOnFirstLogin = true;
        private int expireDays = 90;
        private int historyCount = 3;
    }

    /**
     * IP黑白名单配置
     * mode: off-关闭, blacklist-仅黑名单, whitelist-仅白名单, both-黑白名单同时生效
     */
    @Data
    public static class IpList {
        private String mode = "off";
    }

    /**
     * 租户配置
     * enabled: 是否启用租户数据隔离
     */
    @Data
    public static class Tenant {
        private boolean enabled = false;
    }
}
