package com.aladdin.common.security.filter;

import com.aladdin.common.security.sso.SsoAuth;
import com.aladdin.common.security.sso.SsoUserHolder;
import com.aladdin.common.security.entity.OmUser;
import com.aladdin.common.security.util.WhitelistMatcher;
import com.alibaba.fastjson2.JSON;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SsoLoginFilter implements Filter {

    private static final String TOKEN_HEADER = "X-Token";

    private List<String> whitelist;

    public void setWhitelist(List<String> whitelist) {
        this.whitelist = whitelist;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestPath = getRequestPath(request);
        if (WhitelistMatcher.match(whitelist, requestPath)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String token = request.getHeader(TOKEN_HEADER);
        if (token == null || token.isEmpty()) {
            token = request.getParameter("token");
        }

        if (token != null && !token.isEmpty()) {
            OmUser user = SsoAuth.verifyLogin(token);
            if (user != null) {
                SsoUserHolder.setUser(user);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        if (isAjaxRequest(request)) {
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(200);
            com.aladdin.common.core.domain.R result = com.aladdin.common.core.domain.R.fail(50014, "用户未登录或登录已过期");
            response.getWriter().write(JSON.toJSONString(result));
        } else {
            response.sendRedirect(request.getContextPath() + "/sso/interceptLogin");
        }
    }

    private String getRequestPath(HttpServletRequest request) {
        String contextPath = request.getContextPath();
        String uri = request.getRequestURI();
        if (contextPath != null && !contextPath.isEmpty() && uri.startsWith(contextPath)) {
            uri = uri.substring(contextPath.length());
        }
        return uri;
    }

    private boolean isAjaxRequest(HttpServletRequest request) {
        String xRequestedWith = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equalsIgnoreCase(xRequestedWith);
    }

    @Override
    public void destroy() {
    }
}
