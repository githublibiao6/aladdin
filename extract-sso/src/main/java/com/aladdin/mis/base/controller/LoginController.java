package com.aladdin.mis.base.controller;

import com.aladdin.mis.base.model.param.LoginUser;
import com.aladdin.mis.base.service.AuthLoginService;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
* @Description: 系统
* @Author: cles
* @Date: 2020/4/16 22:17
*/
@Slf4j
@Controller
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private AuthLoginService authLoginService;

    @RequestMapping("/login")
    @ResponseBody
    public JSONObject login(@RequestBody LoginUser user) {
        JSONObject result = new JSONObject();
        result.put("code", 20000);
        Map<String, String> map = new HashMap<>(16);
        map.put("token","admin-token");
        result.put("data", map);
        result = authLoginService.signIn(user);

        return result;
    }

}
