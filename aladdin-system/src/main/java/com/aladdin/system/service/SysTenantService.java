package com.aladdin.system.service;

import com.aladdin.common.db.base.BaseService;
import com.aladdin.system.entity.SysTenant;

/**
 * 租户服务接口
 *
 * @author cles
 * @date 2026/06/12
 */
public interface SysTenantService extends BaseService<SysTenant> {

    SysTenant getByTenantCode(String tenantCode);

    /** 校验租户是否有效 */
    boolean isValid(Long tenantId);
}
