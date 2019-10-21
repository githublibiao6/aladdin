package com.company.system.interceptor.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 登陆拦截
 * @author lb
 * @date 2018年6月5日 下午9:04:51
 */
public class LoginInterceptor implements HandlerInterceptor {

    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        
    }
    
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        
    }
    
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        String requestURI = request.getRequestURI(); 
        System.out.println("********************登陆拦截**************************");
        System.out.println(requestURI);
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute(session.getId()+"username");
        System.out.println(username);
        if(!requestURI.contains("login.do")){
            if(username!=null){
                //登陆成功的用户
                return true;
            }else {
                //没有登陆，转向登陆界面
                System.out.println(request.getContextPath() + "/accessDenied.jsp");
//                response.setStatus(0);
                request.getRequestDispatcher("/accessDenied.jsp").forward(request, response);
//                response.sendRedirect(request.getContextPath() + "/accessDenied.jsp");
                 /*Result r = new Result();
                 r.setSuccess(false);
                 response.setContentType("application/json; charset=UTF-8");
                 response.setStatus(405);
                 response.getWriter().print(r);*/
//               request.getRequestDispatcher("/login.jsp").forward(request,response);
                return false;
            }
        }else {
            return true;
        }
    }

}
