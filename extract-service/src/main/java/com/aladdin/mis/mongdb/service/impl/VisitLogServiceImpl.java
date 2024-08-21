package com.aladdin.mis.mongdb.service.impl;
/*
 *  Created by cles on 2022/2/22 22:47
 */

import com.aladdin.mis.common.system.entity.VisitLog;
import com.aladdin.mis.mongdb.service.VisitLogService;
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
        //todo
//        Subject subject = SecurityUtils.getSubject();
//        if(subject != null){
//            String sessionId = (String) subject.getSession().getId();
//            log.setSessionId(sessionId);
//        }
//        mongoService.save(log);
    }
}
