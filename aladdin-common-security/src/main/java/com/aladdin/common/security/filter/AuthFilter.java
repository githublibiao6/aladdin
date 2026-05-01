package com.aladdin.common.security.filter;

import com.aladdin.common.security.sso.SsoAuth;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 权限校验过滤器
 *
 * @author cles
 * @date 2026/04/30
 */
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        SsoAuth ssoAuth = new SsoAuth();
        boolean enable = ssoAuth.isEnable();
        if (enable) {
            String token = request.getHeader("X-Token");
            SsoAuth.verifyAuth(token);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
