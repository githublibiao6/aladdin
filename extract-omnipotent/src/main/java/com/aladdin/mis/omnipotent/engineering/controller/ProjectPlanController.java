package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectPlan;
import com.aladdin.mis.engineering.service.ProjectPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


    /**
     * 保存数据
     */
    @RequestMapping("save")
    @ResponseBody
    public Result save(@RequestBody ProjectPlan entity) {
        boolean flag = projectPlanService.save(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * 更新数据
     */
    @RequestMapping("update")
    @ResponseBody
    public Result update(@RequestBody ProjectPlan entity) {
        boolean flag = projectPlanService.update(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * 删除数据
     */
    @RequestMapping("deletePlan")
    @ResponseBody
    public Result deletePlan(@RequestBody ProjectPlan entity) {
        boolean flag = projectPlanService.deletePlan(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }
}
