package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.engineering.entity.ProjectTableLog;
import com.aladdin.mis.engineering.service.ProjectTableLogService;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.engineering.qo.ProjectTableLogQo;
import com.aladdin.mis.engineering.vo.ProjectTableLogVo;
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
 * 项目表日志 ProjectTableLogService--- 
 * @author cles
 * @date 2022-06-22T21:14:00.960
*/
@RequestMapping("engineering/projectTableLog")
@Controller
public class ProjectTableLogController  extends GlobalController<ProjectTableLog, ProjectTableLogService> {

    @Autowired
    private ProjectTableLogService projectTableLogService;


    @Override
    protected GlobalService<ProjectTableLog> getBaseService(){
        return projectTableLogService ;
    }

}
