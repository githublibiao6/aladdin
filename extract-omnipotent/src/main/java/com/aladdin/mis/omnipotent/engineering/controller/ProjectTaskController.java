package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectTask;
import com.aladdin.mis.engineering.service.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ProjectTaskService projectTaskService;


    @Override
    protected GlobalService<ProjectTask> getBaseService(){
        return projectTaskService ;
    }


    /**
     * 更新数据
     */
    @RequestMapping("save")
    @ResponseBody
    public Result save(@RequestBody ProjectTask entity) {
        boolean flag = projectTaskService.save(entity);
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
        boolean flag = projectTaskService.update(entity);
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
        boolean flag = projectTaskService.deleteTask(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }
}
