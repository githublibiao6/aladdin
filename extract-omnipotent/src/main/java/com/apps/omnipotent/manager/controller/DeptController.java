package com.apps.omnipotent.manager.controller;

import com.apps.omnipotent.manager.service.DeptService;
import com.apps.omnipotent.manager.service.impl.DeptServiceImpl;
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
