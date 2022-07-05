package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.engineering.entity.ProjectTask;
import com.aladdin.mis.engineering.service.ProjectTaskService;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.engineering.qo.ProjectTaskQo;
import com.aladdin.mis.engineering.vo.ProjectTaskVo;
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
 * 项目任务表 ProjectTaskService--- 
 * @author cles
 * @date 2022-07-05 21:58:00
*/
@RequestMapping("engineering/projectTask")
@Controller
public class ProjectTaskController  extends GlobalController<ProjectTask, ProjectTaskService> {

    @Autowired
    private ProjectTaskService projectTaskService;


    @Override
    protected GlobalService<ProjectTask> getBaseService(){
        return projectTaskService ;
    }

}
