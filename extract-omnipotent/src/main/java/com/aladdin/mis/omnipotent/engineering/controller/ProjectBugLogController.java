package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.engineering.entity.ProjectBugLog;
import com.aladdin.mis.engineering.service.ProjectBugLogService;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.service.GlobalService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 项目权限日志 ProjectBugLogService---
 * @author cles
 * @date 2022-06-07T00:17:39.547
*/
@RequestMapping("engineering/projectBugLog")
@Controller
public class ProjectBugLogController  extends GlobalController<ProjectBugLog, ProjectBugLogService> {

    @Autowired
    private ProjectBugLogService projectBugLogService;


    @Override
    protected GlobalService<ProjectBugLog> getBaseService(){
        return projectBugLogService ;
    }

}
