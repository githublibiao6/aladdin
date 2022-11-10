package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectPlan;
import com.aladdin.mis.engineering.qo.ProjectPlanQo;
import com.aladdin.mis.engineering.service.ProjectPlanService;
import com.aladdin.mis.engineering.vo.ProjectPlanVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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
     * 根据主键删除数据
     */
    @RequestMapping("/detail")
    @ResponseBody
    public Result detail(@RequestBody ProjectPlanVo entity) {
        ProjectPlanVo data = projectPlanService.detail(entity.getId());
        return Result.success(data);
    }

    /**
     * 获取分页
     */
    @PostMapping("/pageVoInfo")
    @ResponseBody
    public Result pageVoInfo(@RequestBody ProjectPlanQo qo) {
        PageInfo<ProjectPlanVo> page = projectPlanService.pageByDto(qo);
        return Result.success(page);
    }

    /**
     * 保存数据
     */
    @RequestMapping("save")
    @ResponseBody
    public Result save(@RequestBody ProjectPlan entity) {
        Integer id = projectPlanService.save(entity);
        if(id != null){
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
     * 开始计划
     */
    @RequestMapping("startPlan")
    @ResponseBody
    public Result startPlan(@RequestBody ProjectPlan entity) {
        boolean flag = projectPlanService.startPlan(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * 挂起（暂缓）计划
     */
    @RequestMapping("hangPlan")
    @ResponseBody
    public Result hangPlan(@RequestBody ProjectPlan entity) {
        boolean flag = projectPlanService.hangPlan(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * 完成计划
     */
    @RequestMapping("continuePlan")
    @ResponseBody
    public Result continuePlan(@RequestBody ProjectPlan entity) {
        boolean flag = projectPlanService.continuePlan(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * 完成计划
     */
    @RequestMapping("completePlan")
    @ResponseBody
    public Result completePlan(@RequestBody ProjectPlan entity) {
        boolean flag = projectPlanService.completePlan(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * 删除计划
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
