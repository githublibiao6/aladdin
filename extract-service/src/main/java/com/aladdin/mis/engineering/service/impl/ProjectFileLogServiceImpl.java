package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.engineering.ProjectFileLogDao;
import com.aladdin.mis.engineering.entity.ProjectFileLog;
import com.aladdin.mis.engineering.service.ProjectFileLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * ProjectFileLogService
 * @author cles
 * @date 2022-05-25T00:28:57.920
*/
@Service
public class ProjectFileLogServiceImpl extends GlobalServiceImpl<ProjectFileLog> implements ProjectFileLogService{

    @Autowired
    private ProjectFileLogDao projectFileLogDao;

}

