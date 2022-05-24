package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.engineering.entity.ProjectFileLog;
import com.aladdin.mis.engineering.service.ProjectFileLogService;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.engineering.qo.ProjectFileLogQo;
import com.aladdin.mis.engineering.vo.ProjectFileLogVo;
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
 * 项目文件记录 ProjectFileLogService--- 
 * @author cles
 * @date 2022-05-25T00:28:57.955
*/
@RequestMapping("engineering/projectFileLog")
@Controller
public class ProjectFileLogController  extends GlobalController<ProjectFileLog, ProjectFileLogService> {

    @Autowired
    private ProjectFileLogService projectFileLogService;


    @Override
    protected GlobalService<ProjectFileLog> getBaseService(){
        return projectFileLogService ;
    }

}
