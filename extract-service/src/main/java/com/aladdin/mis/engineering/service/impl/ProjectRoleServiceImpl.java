package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.engineering.ProjectRoleDao;
import com.aladdin.mis.engineering.entity.ProjectRole;
import com.aladdin.mis.engineering.service.ProjectRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * ProjectRoleService
 * @author cles
 * @date 2021-08-29T23:32:45.168
*/
@Service
public class ProjectRoleServiceImpl extends GlobalServiceImpl<ProjectRole> implements ProjectRoleService{

    @Autowired
    private ProjectRoleDao projectRoleDao;

}

