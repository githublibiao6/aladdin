package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectTable;
import com.aladdin.mis.engineering.service.ProjectTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 项目表 ProjectTableService---
 * @author cles
 * @date 2021-09-14T00:07:18.702
*/
@RequestMapping("engineering/projectTable")
@Controller
public class ProjectTableController  extends GlobalController<ProjectTable, ProjectTableService> {

    @Autowired
    private ProjectTableService projectTableService;

    @Override
    protected GlobalService<ProjectTable> getBaseService() {
        return projectTableService;
    }
}
