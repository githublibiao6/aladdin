package com.aladdin.mis.engineering.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.engineering.ProjectUserRoleDao;
import com.aladdin.mis.engineering.entity.ProjectUserRole;
import com.aladdin.mis.engineering.service.ProjectUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * ProjectUserRoleService
 * @author cles
 * @date 2021-08-31T22:03:55.930
*/
@Service
public class ProjectUserRoleServiceImpl extends GlobalServiceImpl<ProjectUserRole> implements ProjectUserRoleService{

    @Autowired
    private ProjectUserRoleDao projectUserRoleDao;


}

