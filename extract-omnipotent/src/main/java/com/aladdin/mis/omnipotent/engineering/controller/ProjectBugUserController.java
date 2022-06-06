package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.engineering.entity.ProjectBugUser;
import com.aladdin.mis.engineering.service.ProjectBugUserService;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.engineering.qo.ProjectBugUserQo;
import com.aladdin.mis.engineering.vo.ProjectBugUserVo;
import com.aladdin.mis.common.annotation.WebLog;
import com.aladdin.mis.common.system.entity.Result;
import com.github.pagehelper.PageInfo;
import com.aladdin.mis.common.system.service.GlobalService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
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

}
