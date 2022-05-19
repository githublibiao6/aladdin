package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.engineering.entity.ProjectEditionLog;
import com.aladdin.mis.engineering.service.ProjectEditionLogService;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.engineering.qo.ProjectEditionLogQo;
import com.aladdin.mis.engineering.vo.ProjectEditionLogVo;
import com.aladdin.mis.common.annotation.WebLog;
import com.aladdin.mis.common.system.entity.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
/**
 * 项目版本记录 ProjectEditionLogService--- 
 * @author cles
 * @date 2022-05-19T22:18:45.924
*/
@RequestMapping("engineering/projectEditionLog")
@Controller
public class ProjectEditionLogController  extends GlobalController<ProjectEditionLog, ProjectEditionLogService> {

    @Autowired
    private ProjectEditionLogService projectEditionLogService;


    @Override
    protected GlobalService<ProjectEditionLog> getBaseService(){
        return projectEditionLogService ;
    }

}
