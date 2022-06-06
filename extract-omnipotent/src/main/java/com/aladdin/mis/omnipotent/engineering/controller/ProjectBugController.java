package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.engineering.entity.ProjectBug;
import com.aladdin.mis.engineering.service.ProjectBugService;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.engineering.qo.ProjectBugQo;
import com.aladdin.mis.engineering.vo.ProjectBugVo;
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
 * 项目缺陷管理 ProjectBugService--- 
 * @author cles
 * @date 2022-06-07T00:17:28.418
*/
@RequestMapping("engineering/projectBug")
@Controller
public class ProjectBugController  extends GlobalController<ProjectBug, ProjectBugService> {

    @Autowired
    private ProjectBugService projectBugService;


    @Override
    protected GlobalService<ProjectBug> getBaseService(){
        return projectBugService ;
    }

}
