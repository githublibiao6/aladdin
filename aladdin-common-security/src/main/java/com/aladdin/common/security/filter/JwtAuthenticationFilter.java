package com.aladdin.common.security.filter;

import com.aladdin.common.core.context.UserContextHolder;
import com.aladdin.common.security.config.SecurityProperties;
import com.aladdin.common.security.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public JwtAuthenticationFilter(TokenService tokenService, SecurityProperties securityProperties) {
        this.tokenService = tokenService;
        this.securityProperties = securityProperties;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = extractToken(request);
        if (StringUtils.hasText(token) && tokenService.validateToken(token)) {
            Long userId = tokenService.getUserId(token);
            String username = tokenService.getUsername(token);
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(userId, null, authorities);
            authentication.setDetails(username);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserContextHolder.setUserId(userId);
            UserContextHolder.setUsername(username);
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
