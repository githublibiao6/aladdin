package com.aladdin.mis.mongdb.service;
/*
 *  Created by cles on 2022/2/22 22:46
 */


import com.aladdin.mis.common.system.entity.VisitLog;

/**
 * @author cles
 * @description:
 * @Date 2022/2/22 22:46
 */
public interface VisitLogService {

    /**
     * 保存访问日志
     * @param log
     */
    void saveVisitLog(VisitLog log);

}
