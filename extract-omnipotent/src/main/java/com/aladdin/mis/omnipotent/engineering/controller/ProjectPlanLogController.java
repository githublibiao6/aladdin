package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.engineering.entity.ProjectPlanLog;
import com.aladdin.mis.engineering.service.ProjectPlanLogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 项目计划日志 ProjectPlanLogService---
 * @author cles
 * @date 2022-07-06 23:03:24
*/
@RequestMapping("engineering/projectPlanLog")
@Controller
public class ProjectPlanLogController  extends GlobalController<ProjectPlanLog, ProjectPlanLogService> {

}
