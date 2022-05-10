package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectPlan;
import com.aladdin.mis.engineering.service.ProjectPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 项目计划 ProjectPlanService---
 * @author cles
 * @date 2021-08-31T22:26:17.072
*/
@RequestMapping("projectPlan")
@Controller
public class ProjectPlanController  extends GlobalController<ProjectPlan, ProjectPlanService> {

    @Autowired
    private ProjectPlanService projectPlanService;

    @Override
    protected GlobalService<ProjectPlan> getBaseService() {
        return projectPlanService;
    }


}
