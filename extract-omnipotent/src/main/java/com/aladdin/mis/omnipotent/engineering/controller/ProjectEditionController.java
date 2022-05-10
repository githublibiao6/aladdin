package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectEdition;
import com.aladdin.mis.engineering.service.ProjectEditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 项目版本记录 ProjectEditionService---
 * @author cles
 * @date 2022-05-11T01:37:39.288
*/
@RequestMapping("engineering/projectEdition")
@Controller
public class ProjectEditionController  extends GlobalController {

    @Autowired
    private ProjectEditionService projectEditionService;


    @Override
    protected GlobalService<ProjectEdition> getBaseService(){
        return projectEditionService ;
    }

}
