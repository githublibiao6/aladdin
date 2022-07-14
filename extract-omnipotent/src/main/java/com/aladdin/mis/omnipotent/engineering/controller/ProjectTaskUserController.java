package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectTaskUser;
import com.aladdin.mis.engineering.service.ProjectTaskUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 任务人员设置 ProjectTaskUserService---
 * @author cles
 * @date 2022-07-05 21:57:55
*/
@RequestMapping("engineering/projectTaskUser")
@Controller
public class ProjectTaskUserController  extends GlobalController<ProjectTaskUser, ProjectTaskUserService> {

    @Autowired
    private ProjectTaskUserService entityService;


    @Override
    protected GlobalService<ProjectTaskUser> getBaseService(){
        return entityService ;
    }


    /**
     * 更新数据
     */
    @RequestMapping("save")
    @ResponseBody
    public Result save(@RequestBody ProjectTaskUser entity) {
        boolean flag = entityService.save(entity);
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
    public Result hangTask(@RequestBody ProjectTaskUser task) {
        boolean flag = entityService.hangTask(task.getId());
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * 继续任务任务
     */
    @RequestMapping("/continueTask")
    @ResponseBody
    public Result continueTask(@RequestBody ProjectTaskUser task) {
        boolean flag = entityService.continueTask(task.getId());
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * 继续任务任务
     */
    @RequestMapping("/completeTask")
    @ResponseBody
    public Result completeTask(@RequestBody ProjectTaskUser task) {
        boolean flag = entityService.completeTask(task.getId());
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }
}
