package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectFileLog;
import com.aladdin.mis.engineering.service.ProjectFileLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 项目文件记录 ProjectFileLogService---
 * @author cles
 * @date 2022-05-25T00:28:57.955
*/
@RequestMapping("engineering/projectFileLog")
@Controller
public class ProjectFileLogController  extends GlobalController<ProjectFileLog, ProjectFileLogService> {

    @Autowired
    private ProjectFileLogService projectFileLogService;

    @Override
    protected GlobalService<ProjectFileLog> getBaseService(){
        return projectFileLogService ;
    }

}
