package com.company.manage.project.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.manage.project.service.ProjectService;

/**
 * 项目 controller
 * @author lb
 * @date 2018年6月24日 下午6:58:58
 */
@RequestMapping("project")
@Controller
public class ProjectController {
    
    @Resource
    ProjectService service;
    
}
