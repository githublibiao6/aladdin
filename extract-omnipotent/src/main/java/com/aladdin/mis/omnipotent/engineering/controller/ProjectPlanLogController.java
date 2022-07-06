package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.engineering.entity.ProjectPlanLog;
import com.aladdin.mis.engineering.service.ProjectPlanLogService;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.engineering.qo.ProjectPlanLogQo;
import com.aladdin.mis.engineering.vo.ProjectPlanLogVo;
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
