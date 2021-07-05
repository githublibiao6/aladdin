package com.apps.omnipotent.system.controller;

import com.apps.omnipotent.system.global.entity.Result;
import com.apps.omnipotent.system.global.controller.GlobalController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
* @Description: 文档
* @Author: cles
* @Date: 2020/4/16 22:17
*/
@Controller
@RequestMapping("/document")
public class DocsController extends GlobalController {

    @RequestMapping("/index")
    @ResponseBody
    public Result index() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        // 请求路径
        String requestURI = request.getRequestURI();
        String url = "http://"+address.getHostAddress() +":"+request.getServerPort()+"/"+request.getContextPath()
                +"/static/document/_book/index.html";
        result.setData(url);
        return result;
    }

    @RequestMapping("/indexUrl")
    public String url() {
        return "document/_book/index";
    }
}
