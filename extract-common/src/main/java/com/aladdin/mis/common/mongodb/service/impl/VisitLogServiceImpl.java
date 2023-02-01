package com.aladdin.mis.common.mongodb.service.impl;
/*
 *  Created by cles on 2022/2/22 22:47
 */

import com.aladdin.mis.common.mongodb.service.VisitLogService;
import com.aladdin.mis.system.entity.VisitLog;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * @author cles
 * @description:
 * @Date 2022/2/22 22:47
 * @version: 1.0.0
 */
@Service
public class VisitLogServiceImpl  implements VisitLogService {

//    @Autowired
//    private MongoService<VisitLog> mongoService;

    @Override
    public void saveVisitLog(VisitLog log) {
        Subject subject = SecurityUtils.getSubject();
        if(subject != null){
            String sessionId = (String) subject.getSession().getId();
            log.setSessionId(sessionId);
        }
//        mongoService.save(log);
    }
}
