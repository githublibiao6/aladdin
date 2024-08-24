package com.aladdin.mis.sso;

import com.aladdin.mis.identity.service.AuthLoginService;
import com.aladdin.mis.shiro.OmClient;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.system.entity.BeLoginLog;
import com.aladdin.mis.system.service.BeLoginLogService;
import com.aladdin.mis.system.user.vo.LoginUser;
import com.aladdin.mis.system.user.vo.OmUser;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * sso 登录
* @Description:
* @Author: cles
* @Date: 2020/4/16 22:17
*/
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
        try{
            result = new Result();
            result.setCode(20000);

            // shiro 调用
            LoginUser user = new LoginUser();
            user.setUserName(json.getString("username"));
            user.setPassword(json.getString("password"));
            result = authLoginService.signIn(user);

            BeLoginLog loginLog = new BeLoginLog();
            loginLog.setLoginType("10");
            beLoginLogService.saveLoginLog(loginLog);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("登录出错");
            result.setCode(5000);
        }
        return result;
    }

    /**
     * 获取登录token
     * @return
     */
    @RequestMapping("/getToken")
    @ResponseBody
    public Result getToken() {
        Result result = new Result();
        result.setCode(20000);

        Subject subject = SecurityUtils.getSubject();
        // 生成的sessionId 返回给前端
        subject.getSession().setTimeout(1000 * 60 * 30);
        String sessionId = (String)subject.getSession().getId();
        result.setData(sessionId);
        return result;
    }

    /**
     * 获取登录token
     * @return
     */
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public Result getUserInfo() {
        Result result = new Result();
        result.setCode(20000);

        OmUser user = OmClient.getCurrentUser();
        result.setData(user);
        return result;
    }


    /**
     * 未登录的路径 可在ShiroConfig 中设置
     * shiroFilterFactoryBean.setLoginUrl("/system/interceptLogin");
     */
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
        log.error("登录成功了error");
        log.warn("登录成功了warn");
        log.debug("登录成功了debug");
        log.info("登录成功了info");
        log.info("登录成功了info,{}",result.getCode());
        result.setSuccess(false);
        return result;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public Result out(String token) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        Result result = new Result();
        result.setCode(20000);
        result.setMessage("用户退出");
        return result;
    }
}
