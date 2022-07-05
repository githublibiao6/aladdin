package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.engineering.entity.ProjectTaskLog;
import com.aladdin.mis.engineering.service.ProjectTaskLogService;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.engineering.qo.ProjectTaskLogQo;
import com.aladdin.mis.engineering.vo.ProjectTaskLogVo;
import com.aladdin.mis.common.annotation.WebLog;
import com.aladdin.mis.common.system.entity.Result;
import com.github.pagehelper.PageInfo;
import com.aladdin.mis.common.system.service.GlobalService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
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
