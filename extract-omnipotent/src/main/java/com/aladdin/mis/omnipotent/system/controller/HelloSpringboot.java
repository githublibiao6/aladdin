package com.aladdin.mis.omnipotent.system.controller;

import com.aladdin.mis.identity.entity.Menu;
import com.aladdin.mis.identity.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/hello")
public class HelloSpringboot {

    @Autowired
    private MenuServiceImpl service;

    @RequestMapping("/index")
    public String say(Menu m, Model model, @RequestParam(value = "s",defaultValue = "1") String s) {
        List<Menu> list = service.list();
        model.addAttribute("list","list1231");
        model.addAttribute("m",list.get(0));
        System.out.println(list);
        return "/vue/login";
    }
    @RequestMapping("/index2")
    public String react(Menu m, Model model,@RequestParam(value = "s",defaultValue = "1") String s) {
        return "/react/login";
    }

    /**
     *  聊天测试
     * @param m
     * @param model
     * @param s
     * @return
     */
    @RequestMapping("/chat")
    public String chat(Menu m, Model model,@RequestParam(value = "s",defaultValue = "1") String s) {
        return "/vue/chat";
    }
    /**
     *  聊天测试
     * @param m
     * @param model
     * @param s
     * @return
     */
    @RequestMapping("/chat2")
    public String chat2(Menu m, Model model,@RequestParam(value = "s",defaultValue = "1") String s) {
        return "/vue/chat2";
    }
}
