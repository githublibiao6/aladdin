package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.engineering.ProjectUserDao;
import com.aladdin.mis.engineering.entity.ProjectUser;
import com.aladdin.mis.engineering.service.ProjectUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * ProjectUserService
 * @author cles
 * @date 2021-10-12T00:48:58.984
*/
@Service
public class ProjectUserServiceImpl extends GlobalServiceImpl<ProjectUser> implements ProjectUserService{

    @Autowired
    private ProjectUserDao projectUserDao;

}

