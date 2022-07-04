package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectBugUser;
import com.aladdin.mis.engineering.service.ProjectBugUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 缺陷人员设置 ProjectBugUserService---
 * @author cles
 * @date 2022-06-07T00:17:46.100
*/
@RequestMapping("engineering/projectBugUser")
@Controller
public class ProjectBugUserController  extends GlobalController<ProjectBugUser, ProjectBugUserService> {

    @Autowired
    private ProjectBugUserService projectBugUserService;


    @Override
    protected GlobalService<ProjectBugUser> getBaseService(){
        return projectBugUserService ;
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(@RequestBody ProjectBugUser entity) {
        boolean flag = projectBugUserService.save(entity);
        if(flag){
            return Result.success();
        }
        return Result.error();
    }

    /**
     * 更新
     */
    @PostMapping("/update")
    @ResponseBody
    public Result update(@RequestBody ProjectBugUser entity) {
        boolean flag = projectBugUserService.update(entity);
        if(flag){
            return Result.success();
        }
        return Result.error();
    }

    /**
     * 删除
     */
    @PostMapping("/deleteUser")
    @ResponseBody
    public Result deleteUser(@RequestBody ProjectBugUser entity) {
        boolean flag = projectBugUserService.deleteUser(entity);
        if(flag){
            return Result.success();
        }
        return Result.error();
    }


}
