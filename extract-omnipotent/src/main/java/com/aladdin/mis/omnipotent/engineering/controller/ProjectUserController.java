package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.base.qo.QueryCondition;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectUser;
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

    @Override
    protected GlobalService<ProjectUser> getBaseService() {
        return projectUserService;
    }


    /**
     * 获取通用分页
     */
    @PostMapping("/pageVoInfo")
    @ResponseBody
    public Result pageInfo(@RequestBody QueryCondition condition) {
        PageInfo<ProjectUserVo> page = projectUserService.pageVoByCondition(condition);
        return Result.success(page);
    }
}
