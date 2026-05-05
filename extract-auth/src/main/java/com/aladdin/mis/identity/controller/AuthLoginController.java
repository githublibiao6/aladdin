package com.aladdin.mis.identity.controller;

import com.aladdin.common.security.entity.LoginUser;
import com.aladdin.common.security.entity.OmUser;
import com.aladdin.common.security.sso.SsoAuth;
import com.aladdin.mis.identity.service.AuthLoginService;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.shiro.OmClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/auth")
public class AuthLoginController {

    @Autowired
    private AuthLoginService authLoginService;

    @RequestMapping("/login")
    @ResponseBody
    public Result login(@RequestBody LoginUser user) {
        return authLoginService.signIn(user);
    }

    @RequestMapping("/userInfo")
    @ResponseBody
    public Result userInfo() {
        Result result = new Result();
        result.setCode(20000);
        OmUser user = OmClient.getCurrentUser();
        result.setData(user);
        return result;
    }

    @RequestMapping("/interceptLogin")
    @ResponseBody
    public Result interceptLogin() {
        Result result = new Result();
        result.setMessage("用户未登录");
        result.setCode(50014);
        result.setSuccess(false);
        return result;
    }

    @RequestMapping("/unauthorizedUrl")
    @ResponseBody
    public Result unauthorizedUrl() {
        Result result = new Result();
        result.setMessage("没有权限");
        result.setCode(403);
        result.setSuccess(false);
        return result;
    }

    @RequestMapping("/welcome")
    @ResponseBody
    public Result welcome() {
        Result result = new Result();
        result.setMessage("请求成功");
        result.setCode(20000);
        return result;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public Result logout(String token) {
        OmUser user = OmClient.getCurrentUser();
        if (user != null) {
            return authLoginService.signOut(user);
        }
        if (token != null) {
            SsoAuth.removeToken(token);
        }
        Result result = new Result();
        result.setCode(20000);
        result.setMessage("登出成功");
        return result;
    }
}
