package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectPlanUser;
import com.aladdin.mis.engineering.service.ProjectPlanUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**
     * 保存数据
     */
    @RequestMapping("save")
    @ResponseBody
    public Result save(@RequestBody ProjectPlanUser entity) {
        boolean flag = projectPlanUserService.save(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * 删除项目计划人员
     */
    @RequestMapping("deleteUser")
    @ResponseBody
    public Result deleteUser(@RequestBody ProjectPlanUser entity) {
        boolean flag = projectPlanUserService.deleteUser(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }
}
