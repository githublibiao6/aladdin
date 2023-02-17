package com.aladdin.mis.mongdb.service;
/*
 *  Created by cles on 2022/2/22 22:46
 */

import com.aladdin.mis.common.system.entity.VisitExceptionLog;

/**
 * @author cles
 * @description:
 * @Date 2022/2/22 22:46
 */
public interface VisitExceptionLogService {

    /**
     * 保存访问错误日志
     * @param log
     */
    void saveVisitExceptionLog(VisitExceptionLog log);

}
