package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.engineering.entity.ProjectEditionLog;
import com.aladdin.mis.engineering.service.ProjectEditionLogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 项目版本记录 ProjectEditionLogService---
 * @author cles
 * @date 2022-05-19T22:18:45.924
*/
@RequestMapping("engineering/projectEditionLog")
@Controller
public class ProjectEditionLogController  extends GlobalController<ProjectEditionLog, ProjectEditionLogService> {

}
