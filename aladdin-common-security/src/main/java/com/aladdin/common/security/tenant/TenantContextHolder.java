package com.aladdin.common.security.tenant;

import com.aladdin.common.security.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 租户上下文持有者
 * <p>
 * 通过ThreadLocal存储当前请求的租户ID，供数据隔离拦截器使用
 *
 * @author cles
 * @date 2026/06/12
 */
public class TenantContextHolder {

    private static final Logger log = LoggerFactory.getLogger(TenantContextHolder.class);

    private static final ThreadLocal<Long> TENANT_ID = new ThreadLocal<>();

    public static void setTenantId(Long tenantId) {
        TENANT_ID.set(tenantId);
    }

    public static Long getTenantId() {
        return TENANT_ID.get();
    }

    public static void clear() {
        TENANT_ID.remove();
    }
}
