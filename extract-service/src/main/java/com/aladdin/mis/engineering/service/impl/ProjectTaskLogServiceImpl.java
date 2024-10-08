package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.engineering.ProjectTaskLogDao;
import com.aladdin.mis.engineering.entity.ProjectTaskLog;
import com.aladdin.mis.engineering.service.ProjectTaskLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * ProjectTaskLogService
 * @author cles
 * @date 2022-07-05 21:58:10
*/
@Service
public class ProjectTaskLogServiceImpl extends GlobalServiceImpl<ProjectTaskLog> implements ProjectTaskLogService{

    @Autowired
    private ProjectTaskLogDao projectTaskLogDao;

}

