package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.engineering.entity.ProjectUser;
import com.aladdin.mis.engineering.qo.ProjectUserQo;
import com.aladdin.mis.engineering.service.ProjectUserService;
import com.aladdin.mis.engineering.vo.ProjectUserVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  ProjectUserService---
 * @author cles
 * @date 2021-10-12T00:48:59.022
*/
@RequestMapping("engineering/projectUser")
@Controller
public class ProjectUserController  extends GlobalController<ProjectUser, ProjectUserService> {

    @Autowired
    private ProjectUserService projectUserService;

    /**
     * 获取通用分页
     */
    @PostMapping("/pageVoInfo")
    @ResponseBody
    public Result pageInfo(@RequestBody ProjectUserQo condition) {
        PageInfo<ProjectUserVo> page = projectUserService.pageVoByCondition(condition);
        return Result.success(page);
    }

    /**
     * 新增项目用户
     */
    @PostMapping("/addUser")
    @ResponseBody
    public Result addUser(@RequestBody ProjectUser entity) {
        boolean flag = projectUserService.addUser(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * 移除项目用户
     */
    @PostMapping("/removeUser")
    @ResponseBody
    public Result removeUser(@RequestBody ProjectUser entity) {
        boolean flag = projectUserService.removeUser(entity);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }
}
