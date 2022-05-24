package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.engineering.entity.ProjectFile;
import com.aladdin.mis.engineering.service.ProjectFileService;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.engineering.qo.ProjectFileQo;
import com.aladdin.mis.engineering.vo.ProjectFileVo;
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
 * 项目版本文件资料 ProjectFileService--- 
 * @author cles
 * @date 2022-05-25T00:29:11.440
*/
@RequestMapping("engineering/projectFile")
@Controller
public class ProjectFileController  extends GlobalController<ProjectFile, ProjectFileService> {

    @Autowired
    private ProjectFileService projectFileService;


    @Override
    protected GlobalService<ProjectFile> getBaseService(){
        return projectFileService ;
    }

}
