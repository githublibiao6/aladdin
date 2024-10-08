package com.aladdin.mis.permission.controller;

import com.aladdin.mis.common.system.entity.Result;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
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
public class AuthController {

    @RequestMapping("/getToken")
    @ResponseBody
    public Result login(HttpServletRequest request, @RequestBody JSONObject json) {
        Result result = new Result();
        result.setCode(20000);
        Map<String, String> map = new HashMap<>(16);
        map.put("token","admin-token");
        result.setData(map);
        Enumeration<String> set = request.getParameterNames();
        while (set.hasMoreElements()){
            System.err.println(set.nextElement());
        }
        Subject subject = SecurityUtils.getSubject();
        // shiro 调用
        UsernamePasswordToken token = new UsernamePasswordToken(json.getString("username"), json.getString("password"));
        //如果获取不到用户名就是登录失败，但登录失败的话，会直接抛出异常
        try{
            Session session = subject.getSession();
            session.setAttribute("userId",123);
            System.err.println(session.getAttribute("userId"));
//            System.err.println(session.getAttribute("session"));
//            System.err.println(SecurityUtils.getSubject().getSession().getAttribute("session"));
            //重点！！！！！！
            //getAuthenticationInfo 执行时机
            // 会触发 Realm的doGetAuthenticationInfo方法
            subject.login(token);

        }catch (Exception e){
            e.printStackTrace();
        }
        //重点！！！！！！
        //        subject.hasRole(“admin”)
        //        subject.isPermitted(“admin”)
        //        @RequiresRoles(“admin”) ：在方法上加注解的时候；
        //getAuthorizationInfo  执行时机 -- subject.hasRole()
        if (subject.hasRole("admin")) {
            System.err.println("admin");
//            return "redirect:/admin/showComputerProblems";
        } else if (!subject.hasRole("user")) {
            System.err.println("user");
//            return "redirect:/normal/showComputerProblems";
        }
        // 生成的sessionId 返回给前端
        subject.getSession().setTimeout(1000 * 60 * 30);
        String sessionId = (String)subject.getSession().getId();
        result.setData(sessionId);
        return result;
    }

}
