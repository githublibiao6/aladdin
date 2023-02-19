package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.engineering.ProjectTableLogDao;
import com.aladdin.mis.engineering.entity.ProjectTableLog;
import com.aladdin.mis.engineering.service.ProjectTableLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * ProjectTableLogService
 * @author cles
 * @date 2022-06-22T21:14:00.937
*/
@Service
public class ProjectTableLogServiceImpl extends GlobalServiceImpl<ProjectTableLog> implements ProjectTableLogService{

    @Autowired
    private ProjectTableLogDao projectTableLogDao;

}

