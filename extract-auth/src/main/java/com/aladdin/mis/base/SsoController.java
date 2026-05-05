package com.aladdin.mis.base;

import com.aladdin.common.security.entity.LoginUser;
import com.aladdin.common.security.entity.OmUser;
import com.aladdin.common.security.sso.SsoAuth;
import com.aladdin.mis.identity.service.AuthLoginService;
import com.aladdin.mis.shiro.OmClient;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.system.entity.BeLoginLog;
import com.aladdin.mis.system.service.BeLoginLogService;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/sso")
public class SsoController {

    @Autowired
    private AuthLoginService authLoginService;

    @Autowired
    private BeLoginLogService beLoginLogService;

    @RequestMapping("/login")
    @ResponseBody
    public Result login(@RequestBody JSONObject json) {
        Result result = new Result();
        try {
            LoginUser user = new LoginUser();
            user.setUserName(json.getString("username"));
            user.setPassword(json.getString("password"));
            result = authLoginService.signIn(user);

            BeLoginLog loginLog = new BeLoginLog();
            loginLog.setLoginType("10");
            beLoginLogService.saveLoginLog(loginLog);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("登录出错");
            result.setCode(5000);
        }
        return result;
    }

    @RequestMapping("/getToken")
    @ResponseBody
    public Result getToken() {
        Result result = new Result();
        result.setCode(20000);
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setTimeout(1000 * 60 * 30);
        String sessionId = (String) subject.getSession().getId();
        result.setData(sessionId);
        return result;
    }

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public Result getUserInfo() {
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
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        Result result = new Result();
        result.setCode(20000);
        result.setMessage("用户退出");
        return result;
    }
}
