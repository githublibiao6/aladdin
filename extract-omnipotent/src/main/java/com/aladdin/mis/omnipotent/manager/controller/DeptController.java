package com.aladdin.mis.omnipotent.manager.controller;

import com.aladdin.mis.service.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 部门 controller
 * @author lb
 *
 */
@RequestMapping("dept")
@Controller
public class DeptController {

    @Autowired
    DeptServiceImpl service;

    @RequestMapping("main")
    public String test(){

        return "dept/index";
    }

}
