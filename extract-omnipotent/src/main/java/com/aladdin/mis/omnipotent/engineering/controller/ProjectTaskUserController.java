package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
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
     * 删除任务人员
     */
    @RequestMapping("/deleteUser")
    @ResponseBody
    public Result completeTask(@RequestBody ProjectTaskUser taskUser) {
        boolean flag = entityService.deleteUser(taskUser.getId());
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }
}
