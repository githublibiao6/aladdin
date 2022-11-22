package com.aladdin.mis.auth.sso;

import com.aladdin.mis.auth.identity.service.AuthLoginService;
import com.aladdin.mis.common.system.controller.GlobalController;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.system.entity.BeLoginLog;
import com.aladdin.mis.system.service.BeLoginLogService;
import com.aladdin.mis.system.user.vo.OmUser;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
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
public class SsoController extends GlobalController {

    @Autowired
    private AuthLoginService authLoginService;

    @Autowired
    private BeLoginLogService beLoginLogService;

    @RequestMapping("/login")
    @ResponseBody
    public Result login(@RequestBody JSONObject json) {
        try{
            result = new Result();
            result.setCode(20000);
//        Enumeration<String> set = request.getParameterNames();
//        while (set.hasMoreElements()){
//            System.err.println(set.nextElement());
//        }
            // shiro 调用
            OmUser user = new OmUser();
            user.setUserName(json.getString("username"));
            user.setPassword(json.getString("password"));
            result = authLoginService.signIn(user);

            BeLoginLog loginLog = new BeLoginLog();

            loginLog.setLoginIp(getIp());
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
     * 未登录的路径 可在ShiroConfig 中设置
     * shiroFilterFactoryBean.setLoginUrl("/system/interceptLogin");
     */
    @RequestMapping("/interceptLogin")
    @ResponseBody
    public Result login() {
        result.setMessage("用户未登录");
        result.setCode(50014);
        result.setSuccess(false);
        return result;
    }

    @RequestMapping("/unauthorizedUrl")
    @ResponseBody
    public Result unauthorizedUrl() {
        result.setMessage("没有权限");
        result.setCode(403);
        result.setSuccess(false);
        return result;
    }

    @RequestMapping("/welcome")
    @ResponseBody
    public Result welcome() {
        result.setMessage("登陆成功");
        log.info("登录成功了");
        result.setSuccess(false);
        return result;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public Result out(String token) {
        result.setCode(20000);
        result.setMessage("用户退出");
        return result;
    }

    @Override
    protected GlobalService getBaseService() {
        return null;
    }
}
