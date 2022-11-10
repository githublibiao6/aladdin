package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectTaskLog;
import com.aladdin.mis.engineering.service.ProjectTaskLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 项目权限日志 ProjectTaskLogService---
 * @author cles
 * @date 2022-07-05 21:58:10
*/
@RequestMapping("engineering/projectTaskLog")
@Controller
public class ProjectTaskLogController  extends GlobalController<ProjectTaskLog, ProjectTaskLogService> {

    @Autowired
    private ProjectTaskLogService projectTaskLogService;

    @Override
    protected GlobalService<ProjectTaskLog> getBaseService(){
        return projectTaskLogService ;
    }

}
