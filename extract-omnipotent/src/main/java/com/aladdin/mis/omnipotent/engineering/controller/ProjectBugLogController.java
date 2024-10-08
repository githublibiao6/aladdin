package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.engineering.entity.ProjectBugLog;
import com.aladdin.mis.engineering.service.ProjectBugLogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 项目权限日志 ProjectBugLogService---
 * @author cles
 * @date 2022-06-07T00:17:39.547
*/
@RequestMapping("engineering/projectBugLog")
@Controller
public class ProjectBugLogController  extends GlobalController<ProjectBugLog, ProjectBugLogService> {

}
