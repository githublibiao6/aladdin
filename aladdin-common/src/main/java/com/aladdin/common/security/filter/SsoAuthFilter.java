package com.aladdin.common.security.filter;

import com.aladdin.common.security.sso.SsoAuth;
import com.aladdin.common.security.sso.SsoUserHolder;
import com.aladdin.common.security.entity.OmUser;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SsoAuthFilter implements Filter {

    private static final String TOKEN_HEADER = "X-Token";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader(TOKEN_HEADER);
        if (token == null || token.isEmpty()) {
            token = request.getParameter("token");
        }

        if (token != null && !token.isEmpty()) {
            OmUser user = SsoAuth.verifyLogin(token);
            if (user != null) {
                SsoUserHolder.setUser(user);
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
