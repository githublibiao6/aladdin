package com.aladdin.mis.omnipotent.system.filter;
/*
 *  Created by cles on 2021/4/14 0:16
 */
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author cles
 * @description: 登录信息过滤
 * @Date 2021/4/14 0:16
 * @version: 1.0.0
 */
public class LogCostFilter  implements Filter {

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
        String requestURI = request.getRequestURI();
        if (!requestURI.contains("login")) {
            System.err.println("LogCostFilter method" + request.getMethod());
            String token = request.getHeader("X-Token");
            System.err.println("LogCostFilter X-Token : "+ token);
            filterChain.doFilter(servletRequest, servletResponse);
            /*if (session != null && session.getAttribute("name") != null) {
                filterChain.doFilter(request, response);
            } else {
                String requestType = request.getHeader("X-Requested-With");
                if (requestType != null && "XMLHttpRequest".equals(requestType)) {
                    response.getWriter().write("NO_LOGIN");
                } else {
                    response.sendRedirect(request.getContextPath() + "/login");
                }
                return;
            }*/
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
