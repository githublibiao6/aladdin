package com.aladdin.mis.omnipotent.system.controller;

import com.aladdin.mis.bill.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cles
 */
@Controller
@RequestMapping("/route")
public class RouteController {

    @Autowired
    MenuService service;

    /**
     * 主路径
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        service.list();
        return "/index";
    }

    @RequestMapping("/index1")
    public String index1() {
        return "/index1";
    }
}
