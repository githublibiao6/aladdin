package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectPlanUser;
import com.aladdin.mis.engineering.service.ProjectPlanUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 项目计划参与人员 ProjectPlanUserService---
 * @author cles
 * @date 2021-08-29T23:32:31.977
*/
@RequestMapping("projectPlanUser")
@Controller
public class ProjectPlanUserController  extends GlobalController<ProjectPlanUser, ProjectPlanUserService> {

    @Autowired
    private ProjectPlanUserService projectPlanUserService;

    @Override
    protected GlobalService<ProjectPlanUser> getBaseService() {
        return projectPlanUserService;
    }
}
