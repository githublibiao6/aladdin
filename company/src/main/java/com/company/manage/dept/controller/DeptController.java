package com.company.manage.dept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.manage.dept.service.DeptService;
/**
 * 部门 controller
 * @author lb
 *
 */
@RequestMapping("dept")
@Controller
public class DeptController {
    
    @Autowired
    DeptService service;
    
    @RequestMapping("main")
    public String test(){
        
        return "dept/index";
    }

}
