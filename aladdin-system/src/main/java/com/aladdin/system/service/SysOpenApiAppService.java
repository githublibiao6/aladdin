package com.aladdin.system.service;

import com.aladdin.common.db.base.BaseService;
import com.aladdin.system.entity.SysOpenApiApp;

/**
 * Open-API应用服务接口
 *
 * @author cles
 * @date 2026/06/12
 */
public interface SysOpenApiAppService extends BaseService<SysOpenApiApp> {

    SysOpenApiApp getByAccessKey(String accessKey);
}
