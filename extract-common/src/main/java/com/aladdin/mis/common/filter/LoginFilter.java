package com.aladdin.mis.common.filter;
/*
 *  Created by cles on 2021/12/29 22:05
 */

import com.aladdin.mis.common.sso.SsoAuth;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author cles
 * @description: 登录校验过滤
 * @Date 2021/12/29 22:05
 * @version: 1.0.0
 */
public class LoginFilter  implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LogCostFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        SsoAuth ssoAuth = new SsoAuth();
        boolean enable = ssoAuth.isEnable();
        if(enable){
            String token = request.getHeader("X-Token");
            SsoAuth.verifyLogin(token);
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
