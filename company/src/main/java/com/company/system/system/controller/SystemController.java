package com.company.system.system.controller;

import com.company.manage.admin.bean.Admin;
import com.company.manage.menu.service.impl.MenuServiceImpl;
import com.company.system.common.util.MD5Util;
import com.company.system.redis.dao.impl.RedisBaiseTakesImpl;
import com.company.system.system.service.TestService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("system")
@Controller
public class SystemController {
    
    @Autowired
    TestService service;
    
    @Autowired
    MenuServiceImpl menuService;
    
    @Resource
    private RedisBaiseTakesImpl seeUserRedisTakes;

    /**
     * @Author cles 主页面刷新
     * @Description
     * @Param [m]
     * @Date 20:27 2019/7/14
     * @return java.lang.String
     **/
    @RequestMapping("index")
    public String index(Model m){
        Session session = SecurityUtils.getSubject().getSession();
        Object o = session.getAttribute(session.getId());
        System.out.println(session.getId());
        System.out.println(o);
        m.addAttribute("user",o);
        return "system/index";
    }
    /**
     * @Author cles
     * @Description 登錄功能，还要优化
     * @Param [m, admin, request, response]
     * @Date 20:25 2019/7/14
     * @return java.lang.String
     **/
    @RequestMapping("/login")
    public String login(Model m, Admin admin, HttpServletRequest request, HttpServletResponse response){
        System.err.println("开始登陆");
        Session session = SecurityUtils.getSubject().getSession();

        if( null != session.getAttribute(session.getId())){
            Object o = session.getAttribute(session.getId());
            m.addAttribute("user",o);
            return "system/index";
        }
        if (admin == null || admin.getLoginPassword() == null) {
            return "../../login";
        }
        Subject currenrUser = SecurityUtils.getSubject();
        if(!currenrUser.isAuthenticated()){
//            token.setRememberMe(true);
            try {
                System.out.println("开始shiro");
                UsernamePasswordToken token = new UsernamePasswordToken(
                        admin.getLoginName(),
                        MD5Util.MD5(admin.getLoginPassword()));
                SecurityUtils.getSubject().login(token);
                currenrUser.login(token);
            } catch (AuthenticationException e) {
                System.out.println("登录失败"+e.getMessage());
                //返回登陆界面
                return "../../login";
            }
        }
        Object o = session.getAttribute(session.getId());
        m.addAttribute("user",o);
        return "index.jsp";
    }
    /**
     * @Author cles
     * @Description  登出（注销）
     * @Param []
     * @Date 20:28 2019/7/14
     * @return java.lang.String
     **/
    @RequestMapping("logout")
    public String logout(){
        Session session = SecurityUtils.getSubject().getSession();
        session.removeAttribute(session.getId());
        session.removeAttribute(session.getId()+"id");
        session.removeAttribute(session.getId()+"username");
        System.err.println("退出登陆");
        return "system/index";
    }
///////////
    /**
     * 测试redis
     * @return
     */
    @RequestMapping("/hello.do")
    public ModelAndView hello(){
        ModelAndView mv = new ModelAndView();
        System.out.println("hello see");
        seeUserRedisTakes.add("hello1","zxm");
        mv.setViewName("hello");
        return mv;
    }
    
    @RequestMapping("/user")
    public String user(){
        ModelAndView mv = new ModelAndView();
        //System.out.println("hello see");
        //seeUserRedisTakes.add("hello1","zxm");
        mv.setViewName("test/user");
        return "test/user";
    }
    
    @RequestMapping("/admin.do")
    @RequiresRoles({"admin"})
    public ModelAndView admin(){
        System.out.println("*******进入admin**************");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("test/admin");
        return mv;
    }
}
