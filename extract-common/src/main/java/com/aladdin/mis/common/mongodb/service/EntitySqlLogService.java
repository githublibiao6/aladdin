package com.aladdin.mis.common.mongodb.service;
/*
 *  Created by cles on 2022/2/22 22:46
 */

import com.aladdin.mis.system.entity.SqlLog;

/**
 * @author cles
 * @description:
 * @Date 2022/2/22 22:46
 */
public interface EntitySqlLogService {

    void saveEntitySqlLog(SqlLog log);

}
