package com.aladdin.common.db.interceptor;

/**
 * 数据权限处理器接口
 *
 * @author cles
 * @date 2026/05/06
 */
public interface DataPermissionHandler {

    /**
     * 获取数据权限SQL片段
     *
     * @param parameter 参数对象
     * @return 权限SQL条件
     */
    String getPermissionSql(Object parameter);
}
