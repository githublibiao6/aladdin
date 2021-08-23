package com.aladdin.mis.omnipotent.business.controller;

import com.aladdin.mis.manager.service.Project1Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 业务项目 controller
 * @author lb
 * @date 2018年6月24日 下午6:58:58
 */
@RequestMapping("project1")
@Controller
public class Project1Controller {

    @Resource
    Project1Service service;

}
