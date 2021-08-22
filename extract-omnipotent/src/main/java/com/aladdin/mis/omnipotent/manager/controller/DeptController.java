package com.aladdin.mis.omnipotent.manager.controller;

import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.manager.service.impl.DeptServiceImpl;
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
public class DeptController extends GlobalController/*<Dept, DeptServiceImpl>*/ {

    @Autowired
    DeptServiceImpl service;

    @RequestMapping("main")
    public String test(){

        return "dept/index";
    }

}
