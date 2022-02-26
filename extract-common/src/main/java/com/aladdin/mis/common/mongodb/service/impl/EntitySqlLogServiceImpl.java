package com.aladdin.mis.common.mongodb.service.impl;
/*
 *  Created by cles on 2022/2/22 22:47
 */

import com.aladdin.mis.common.mongodb.service.EntitySqlLogService;
import com.aladdin.mis.common.mongodb.service.MongoService;
import com.aladdin.mis.system.entity.SqlLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cles
 * @description:
 * @Date 2022/2/22 22:47
 * @version: 1.0.0
 */
@Service
public class EntitySqlLogServiceImpl implements EntitySqlLogService {

    @Autowired
    private MongoService<SqlLog> mongoService;

    @Override
    public void saveEntitySqlLog(SqlLog log) {
        mongoService.save(log);
    }
}
