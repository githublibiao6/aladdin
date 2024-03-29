package com.aladdin.mis.common.mongodb.service.impl;
/*
 *  Created by cles on 2022/2/22 22:47
 */

import com.aladdin.mis.common.mongodb.service.MongoService;
import com.aladdin.mis.common.mongodb.service.VisitExceptionLogService;
import com.aladdin.mis.system.entity.VisitExceptionLog;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author cles
 * @description:
 * @Date 2022/2/22 22:47
 * @version: 1.0.0
 */
@Service
public class VisitExceptionLogServiceImpl implements VisitExceptionLogService {

    @Autowired
    private MongoService<VisitExceptionLog> mongoService;

    @Override
    public void saveVisitExceptionLog(VisitExceptionLog log) {
        Subject subject = SecurityUtils.getSubject();
        if(subject != null){
            String sessionId = (String) subject.getSession().getId();
            log.setSessionId(sessionId);
        }

        log.setCreateTime(LocalDateTime.now());
        mongoService.save(log);

    }
}
