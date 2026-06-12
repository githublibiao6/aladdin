package com.aladdin.system.service.impl;

import com.aladdin.common.db.base.BaseServiceImpl;
import com.aladdin.system.dao.SysOpenApiAppDao;
import com.aladdin.system.entity.SysOpenApiApp;
import com.aladdin.system.service.SysOpenApiAppService;
import org.springframework.stereotype.Service;

/**
 * Open-API应用服务实现
 *
 * @author cles
 * @date 2026/06/12
 */
@Service
public class SysOpenApiAppServiceImpl extends BaseServiceImpl<SysOpenApiAppDao, SysOpenApiApp> implements SysOpenApiAppService {

    @Override
    public SysOpenApiApp getByAccessKey(String accessKey) {
        return getMapper().selectByAccessKey(accessKey);
    }
}
