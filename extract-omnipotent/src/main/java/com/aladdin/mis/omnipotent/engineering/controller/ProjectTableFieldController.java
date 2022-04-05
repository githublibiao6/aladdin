package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectTableField;
import com.aladdin.mis.engineering.service.ProjectTableFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 项目表字段 ProjectTableFieldService---
 * @author cles
 * @date 2021-08-31T22:05:10.402
*/
@RequestMapping("projectTableField")
@Controller
public class ProjectTableFieldController  extends GlobalController<ProjectTableField,ProjectTableFieldService> {
    @Autowired
    private ProjectTableFieldService projectTableFieldService;

    @Override
    protected GlobalService<ProjectTableField> getBaseService() {
        return projectTableFieldService;
    }
}
