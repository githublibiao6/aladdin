package com.aladdin.mis.omnipotent.engineering.controller;

import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.engineering.entity.ProjectTableLog;
import com.aladdin.mis.engineering.service.ProjectTableLogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 项目表日志 ProjectTableLogService---
 * @author cles
 * @date 2022-06-22T21:14:00.960
*/
@RequestMapping("engineering/projectTableLog")
@Controller
public class ProjectTableLogController  extends GlobalController<ProjectTableLog, ProjectTableLogService> {

}
