package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.engineering.entity.ProjectTask;
import com.aladdin.mis.engineering.service.ProjectTaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 项目任务表 ProjectTaskService---
 * @author cles
 * @date 2022-07-05 21:58:00
*/
@RequestMapping("engineering/projectTask")
@Controller
public class ProjectTaskController  extends GlobalController<ProjectTask, ProjectTaskService> {

    /**
     * 更新数据
     */
    @RequestMapping("save")
    @ResponseBody
    public Result save(@RequestBody ProjectTask entity) {
        boolean flag = baseService.save(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * 更新数据
     */
    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody ProjectTask entity) {
        boolean flag = baseService.update(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * 开始任务
     */
    @RequestMapping("/startTask")
    @ResponseBody
    public Result startTask(@RequestBody ProjectTask entity) {
        boolean flag = baseService.startTask(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * 挂起任务
     */
    @RequestMapping("/hangTask")
    @ResponseBody
    public Result hangTask(@RequestBody ProjectTask entity) {
        boolean flag = baseService.hangTask(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * 继续任务
     */
    @RequestMapping("/continueTask")
    @ResponseBody
    public Result continueTask(@RequestBody ProjectTask entity) {
        boolean flag = baseService.continueTask(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * 删除数据
     */
    @RequestMapping("/deleteTask")
    @ResponseBody
    public Result deleteTask(@RequestBody ProjectTask entity) {
        boolean flag = baseService.deleteTask(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * 完成任务
     */
    @RequestMapping("/completeTask")
    @ResponseBody
    public Result completeTask(@RequestBody ProjectTask entity) {
        boolean flag = baseService.completeTask(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * 关闭任务
     */
    @RequestMapping("/closeTask")
    @ResponseBody
    public Result closeTask(@RequestBody ProjectTask entity) {
        boolean flag = baseService.closeTask(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }
}
