package com.company.manage.dict.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.manage.dict.service.DictObjService;
import com.company.manage.dict.service.DictService;

/**
 * 字典 Controller
 * @author lb
 *
 */
@Controller
@RequestMapping(value = "/dict")
public class DictController {
    
    @Autowired
    private DictService dictService;
    @Autowired
    private DictObjService dictObjService;
    

}
