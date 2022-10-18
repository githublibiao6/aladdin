package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.engineering.ProjectPlanLogDao;
import com.aladdin.mis.engineering.entity.ProjectPlanLog;
import com.aladdin.mis.engineering.service.ProjectPlanLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * ProjectPlanLogService
 * @author cles
 * @date 2022-07-06 23:03:24
*/
@Service
public class ProjectPlanLogServiceImpl extends GlobalServiceImpl<ProjectPlanLog> implements ProjectPlanLogService{

    @Autowired
    private ProjectPlanLogDao projectPlanLogDao;

}

