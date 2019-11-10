package com.aladdin.system.manage.controller;

import com.aladdin.api.out.interfaces.TestInterface;
import com.aladdin.manage.admin.pojo.AdminTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * test controller
 * @author lb
 * @date 2018年6月5日 下午8:56:11
 */
@RequestMapping("test")
@Controller
public class TestController {

    @Autowired
    private TestInterface service;
    /**
     * 菜单跳转
     *
     * @return
     */
    @RequestMapping("/index.do")
    public String index() {
        List<AdminTest> list = service.getList();
        System.err.println(list);
        return "test/index";
    }

}
