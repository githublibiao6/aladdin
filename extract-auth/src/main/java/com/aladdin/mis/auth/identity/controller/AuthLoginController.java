package com.aladdin.mis.auth.identity.controller;

import com.aladdin.mis.auth.identity.service.AuthLoginService;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.system.user.vo.OmUser;
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
public class AuthLoginController {

    @Autowired
    private AuthLoginService authLoginService;

    @RequestMapping("/login")
    @ResponseBody
    public Result login(@RequestBody OmUser user) {
        Result result = new Result();
        result.setCode(20000);
        Map<String, String> map = new HashMap<>(16);
        map.put("token","admin-token");
        result.setData(map);
        result = authLoginService.signIn(user);

        return result;
    }

    @RequestMapping("/interceptLogin")
    @ResponseBody
    public Result login() {
        Result result = new Result();
        result.setMessage("请求被拦截了");
        result.setCode(50014);
        return result;
    }

    @RequestMapping("/unauthorizedUrl")
    @ResponseBody
    public Result unauthorizedUrl() {
        Result result = new Result();
        result.setMessage("没有权限");
        result.setCode(403);
        return result;
    }

    @RequestMapping("/welcome")
    @ResponseBody
    public Result welcome() {
        Result result = new Result();
        result.setMessage("请求成功");
        log.info("登录成功了");
        return result;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public Result out(String token) {
        Result result = new Result();
        result.setCode(20000);
        result.setMessage("登出成功！");
        return result;
    }

}
