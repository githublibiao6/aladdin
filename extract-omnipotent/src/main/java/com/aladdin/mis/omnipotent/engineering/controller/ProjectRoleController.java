package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectRole;
import com.aladdin.mis.engineering.service.ProjectRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 项目角色 ProjectRoleService---
 * @author cles
 * @date 2021-08-29T23:32:45.168
*/
@RequestMapping("projectRole")
@Controller
public class ProjectRoleController  extends GlobalController<ProjectRole, ProjectRoleService> {

    @Autowired
    private ProjectRoleService projectRoleService;

    @Override
    protected GlobalService<ProjectRole> getBaseService() {
        return projectRoleService;
    }
}
