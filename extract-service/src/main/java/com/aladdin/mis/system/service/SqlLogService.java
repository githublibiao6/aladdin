package com.aladdin.mis.system.service;

import com.aladdin.mis.system.entity.SqlLog;

/**
 * SqlLogService
 * @author cles
 * @date 2021-09-01T00:35:30.807
*/
public interface SqlLogService   {

    /**
     * 保存请求日志
     * @param entity
     */
    void save(SqlLog entity);

}
