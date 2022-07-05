package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.engineering.entity.ProjectPlanUser;
import com.aladdin.mis.engineering.service.ProjectPlanUserService;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.engineering.qo.ProjectPlanUserQo;
import com.aladdin.mis.engineering.vo.ProjectPlanUserVo;
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
 * 项目计划参与人员 ProjectPlanUserService--- 
 * @author cles
 * @date 2022-07-05 21:57:37
*/
@RequestMapping("engineering/projectPlanUser")
@Controller
public class ProjectPlanUserController  extends GlobalController<ProjectPlanUser, ProjectPlanUserService> {

    @Autowired
    private ProjectPlanUserService projectPlanUserService;


    @Override
    protected GlobalService<ProjectPlanUser> getBaseService(){
        return projectPlanUserService ;
    }

}
