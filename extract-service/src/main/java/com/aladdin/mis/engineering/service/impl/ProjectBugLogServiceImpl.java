package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.engineering.ProjectBugLogDao;
import com.aladdin.mis.engineering.entity.ProjectBugLog;
import com.aladdin.mis.engineering.service.ProjectBugLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * ProjectBugLogService
 * @author cles
 * @date 2022-06-07T00:17:39.546
*/
@Service
public class ProjectBugLogServiceImpl extends GlobalServiceImpl<ProjectBugLog> implements ProjectBugLogService{

    @Autowired
    private ProjectBugLogDao projectBugLogDao;

}

