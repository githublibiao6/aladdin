package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.engineering.entity.ProjectPlan;
import com.aladdin.mis.engineering.service.ProjectPlanService;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.engineering.qo.ProjectPlanQo;
import com.aladdin.mis.engineering.vo.ProjectPlanVo;
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
 * 项目计划清单 ProjectPlanService--- 
 * @author cles
 * @date 2022-07-04 21:42:33
*/
@RequestMapping("engineering/projectPlan")
@Controller
public class ProjectPlanController  extends GlobalController<ProjectPlan, ProjectPlanService> {

    @Autowired
    private ProjectPlanService projectPlanService;


    @Override
    protected GlobalService<ProjectPlan> getBaseService(){
        return projectPlanService ;
    }

}
