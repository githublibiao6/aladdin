package com.aladdin.mis.system.service.impl;

import com.aladdin.common.db.bean.SqlLog;
import com.aladdin.mis.system.service.SqlLogService;
import org.springframework.stereotype.Service;

/**
 * SysWebLogService
 * @author cles
 * @date 2021-09-01T00:35:30.811
*/
@Service
public class SqlLogServiceImpl  implements SqlLogService {

//    @Autowired
//    private SqlLogDao sqlLogDao;

    @Override
    public void save(SqlLog entity) {
        // todo 处理启动问题
//        sqlLogDao.save(entity);
    }
}

