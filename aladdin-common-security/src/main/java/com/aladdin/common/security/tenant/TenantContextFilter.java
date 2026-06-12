package com.aladdin.common.security.tenant;

import com.aladdin.common.security.service.LoginUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 租户上下文过滤器
 * <p>
 * 从当前登录用户信息中提取租户ID，设置到TenantContextHolder
 * 后续SQL拦截器根据此租户ID自动拼接数据隔离条件
 *
 * @author cles
 * @date 2026/06/12
 */
public class TenantContextFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.getPrincipal() instanceof LoginUserDetails) {
                LoginUserDetails loginUser = (LoginUserDetails) authentication.getPrincipal();
                // 从LoginUserDetails获取tenantId（需在用户加载时设置）
                Object tenantId = loginUser.getAttribute("tenantId");
                if (tenantId instanceof Long) {
                    TenantContextHolder.setTenantId((Long) tenantId);
                }
            }
            filterChain.doFilter(request, response);
        } finally {
            TenantContextHolder.clear();
        }
    }
}
