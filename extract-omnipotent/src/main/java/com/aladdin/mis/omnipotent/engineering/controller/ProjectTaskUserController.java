package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.engineering.entity.ProjectTaskUser;
import com.aladdin.mis.engineering.service.ProjectTaskUserService;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.engineering.qo.ProjectTaskUserQo;
import com.aladdin.mis.engineering.vo.ProjectTaskUserVo;
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
 * 任务人员设置 ProjectTaskUserService--- 
 * @author cles
 * @date 2022-07-05 21:57:55
*/
@RequestMapping("engineering/projectTaskUser")
@Controller
public class ProjectTaskUserController  extends GlobalController<ProjectTaskUser, ProjectTaskUserService> {

    @Autowired
    private ProjectTaskUserService projectTaskUserService;


    @Override
    protected GlobalService<ProjectTaskUser> getBaseService(){
        return projectTaskUserService ;
    }

}
