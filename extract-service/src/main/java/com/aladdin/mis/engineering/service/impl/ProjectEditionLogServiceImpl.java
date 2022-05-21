package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.engineering.service.ProjectEditionLogService;
import com.aladdin.mis.engineering.entity.ProjectEditionLog;
import com.aladdin.mis.dao.engineering.ProjectEditionLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProjectEditionLogService
 * @author cles
 * @date 2022-05-19T22:18:45.894
*/
@Service
public class ProjectEditionLogServiceImpl extends GlobalServiceImpl<ProjectEditionLog> implements ProjectEditionLogService{

    @Autowired
    private ProjectEditionLogDao projectEditionLogDao;

}

