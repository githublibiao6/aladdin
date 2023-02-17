package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.system.controller.GlobalController;
import com.aladdin.mis.engineering.entity.ProjectTaskLog;
import com.aladdin.mis.engineering.service.ProjectTaskLogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 项目权限日志 ProjectTaskLogService---
 * @author cles
 * @date 2022-07-05 21:58:10
*/
@RequestMapping("engineering/projectTaskLog")
@Controller
public class ProjectTaskLogController  extends GlobalController<ProjectTaskLog, ProjectTaskLogService> {

}
