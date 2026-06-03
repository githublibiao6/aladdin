package com.aladdin.common.security.filter;

import com.aladdin.common.core.context.UserContextHolder;
import com.aladdin.common.security.config.SecurityProperties;
import com.aladdin.common.security.service.LoginUserDetails;
import com.aladdin.common.security.service.SecurityUserDetailsService;
import com.aladdin.common.security.service.TokenService;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * JWT认证过滤器
 *
 * @author cles
 * @date 2026/05/06
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    private final TokenService tokenService;
    private final SecurityProperties securityProperties;
    private SecurityUserDetailsService userDetailsService;

    public JwtAuthenticationFilter(TokenService tokenService, SecurityProperties securityProperties) {
        this.tokenService = tokenService;
        this.securityProperties = securityProperties;
    }

    public void setUserDetailsService(SecurityUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = extractToken(request);
        if (StringUtils.hasText(token) && tokenService.validateToken(token)) {
            try {
                Claims claims = tokenService.parseToken(token);
                Long userId = Long.parseLong(claims.getSubject());
                String username = claims.get("username", String.class);

                Set<String> permissions = new HashSet<>();
                Object permsObj = claims.get("permissions");
                if (permsObj instanceof List) {
                    @SuppressWarnings("unchecked")
                    List<String> perms = (List<String>) permsObj;
                    permissions.addAll(perms);
                }

                // 如果JWT中没有权限信息，从UserDetailsService重新加载
                if (permissions.isEmpty() && userDetailsService != null) {
                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                    if (userDetails != null) {
                        for (GrantedAuthority auth : userDetails.getAuthorities()) {
                            permissions.add(auth.getAuthority());
                        }
                    }
                }

                LoginUserDetails loginUser = new LoginUserDetails(userId, username, "", 1, permissions);

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);

                UserContextHolder.setUserId(userId);
                UserContextHolder.setUsername(username);

                String refreshedToken = tokenService.refreshToken(token);
                if (refreshedToken != null && !refreshedToken.equals(token)) {
                    response.setHeader(securityProperties.getToken().getHeader(),
                            securityProperties.getToken().getPrefix() + refreshedToken);
                }
            } catch (Exception e) {
                log.warn("JWT认证处理异常: {}", e.getMessage());
                SecurityContextHolder.clearContext();
            }
        }
        try {
            filterChain.doFilter(request, response);
        } finally {
            UserContextHolder.clear();
        }
    }

    private String extractToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(securityProperties.getToken().getHeader());
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(securityProperties.getToken().getPrefix())) {
            return bearerToken.substring(securityProperties.getToken().getPrefix().length());
        }
        return bearerToken;
    }
}
