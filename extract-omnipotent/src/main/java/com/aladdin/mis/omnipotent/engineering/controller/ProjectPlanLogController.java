package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectPlanLog;
import com.aladdin.mis.engineering.service.ProjectPlanLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 项目计划日志 ProjectPlanLogService---
 * @author cles
 * @date 2022-07-06 23:03:24
*/
@RequestMapping("engineering/projectPlanLog")
@Controller
public class ProjectPlanLogController  extends GlobalController<ProjectPlanLog, ProjectPlanLogService> {

    @Autowired
    private ProjectPlanLogService projectPlanLogService;

    @Override
    protected GlobalService<ProjectPlanLog> getBaseService(){
        return projectPlanLogService ;
    }

}
