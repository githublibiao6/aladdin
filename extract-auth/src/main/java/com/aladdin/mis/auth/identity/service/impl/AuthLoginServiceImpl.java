package com.aladdin.mis.auth.identity.service.impl;

import com.aladdin.mis.auth.identity.service.AuthLoginService;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.system.user.vo.LoginUser;
import com.aladdin.mis.system.user.vo.OmUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;


/**
 * 用户登录 Service
 * @author lb
 *
 */
@Service
public class AuthLoginServiceImpl implements AuthLoginService {

    @Override
    public Result signIn(LoginUser user) {
        Result result = new Result();
//        Enumeration<String> set = request.getParameterNames();
//        while (set.hasMoreElements()){
//            System.err.println(set.nextElement());
//        }
        Subject subject = SecurityUtils.getSubject();
        // shiro 调用
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        //如果获取不到用户名就是登录失败，但登录失败的话，会直接抛出异常
        try{
            Session session = subject.getSession();
            session.setAttribute("userId",123);
            System.err.println(session.getAttribute("userId"));
            //重点！！！！！！
            //getAuthenticationInfo 执行时机
            // 会触发 Realm的doGetAuthenticationInfo方法
            subject.login(token);

        }catch (AccountException accountException){
            result.setMessage(accountException.getMessage());
            result.setSuccess(false);
            result.setCode(10001);
            return result;
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
        // session 超时时间
        subject.getSession().setTimeout(1000 * 60 * 30);
        String sessionId = (String)subject.getSession().getId();
        result.setData(sessionId);
        subject.getPrincipal();
        return result;
    }

    @Override
    public Result signOut(OmUser user) {
        return null;
    }
}
