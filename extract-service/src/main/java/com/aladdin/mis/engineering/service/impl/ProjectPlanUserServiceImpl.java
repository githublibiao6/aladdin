package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.engineering.ProjectPlanUserDao;
import com.aladdin.mis.engineering.entity.ProjectPlanUser;
import com.aladdin.mis.engineering.service.ProjectPlanUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * ProjectPlanUserService
 * @author cles
 * @date 2021-08-29T23:32:31.976
*/
@Service
public class ProjectPlanUserServiceImpl extends GlobalServiceImpl<ProjectPlanUser> implements ProjectPlanUserService{

    @Autowired
    private ProjectPlanUserDao projectPlanUserDao;


}

