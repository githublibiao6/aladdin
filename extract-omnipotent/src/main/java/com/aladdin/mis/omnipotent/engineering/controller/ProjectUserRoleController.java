package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectUserRole;
import com.aladdin.mis.engineering.service.ProjectUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *  ProjectUserRoleService---
 * @author cles
 * @date 2021-08-31T22:03:55.931
*/
@RequestMapping("projectUserRole")
@Controller
public class ProjectUserRoleController  extends GlobalController<ProjectUserRole,ProjectUserRoleService> {

    @Autowired
    private ProjectUserRoleService projectUserRoleService;

    @Override
    protected GlobalService<ProjectUserRole> getBaseService() {
        return projectUserRoleService;
    }
}
