package com.aladdin.common.security.filter;

import com.aladdin.common.security.config.SecurityProperties;
import com.aladdin.common.security.service.LoginUserDetails;
import com.aladdin.common.security.service.SecurityUserDetailsService;
import com.aladdin.common.security.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.DefaultClaims;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * JwtAuthenticationFilter 单元测试
 * 覆盖：Token解析、权限加载、无Token场景、无效Token、权限重新加载
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@DisplayName("JWT认证过滤器测试")
class JwtAuthenticationFilterTest {

    @Mock
    private TokenService tokenService;

    @Mock
    private SecurityProperties securityProperties;

    @Mock
    private SecurityUserDetailsService userDetailsService;

    @Mock
    private FilterChain filterChain;

    @Mock
    private SecurityProperties.Token tokenProperties;

    private JwtAuthenticationFilter filter;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @BeforeEach
    void setUp() {
        SecurityContextHolder.clearContext();

        filter = new JwtAuthenticationFilter(tokenService, securityProperties);
        filter.setUserDetailsService(userDetailsService);

        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();

        when(securityProperties.getToken()).thenReturn(tokenProperties);
        when(tokenProperties.getHeader()).thenReturn("Authorization");
        when(tokenProperties.getPrefix()).thenReturn("Bearer ");
    }

    // ==================== 无Token场景 ====================

    @Test
    @DisplayName("无Token请求 - 不设置认证信息，继续过滤链")
    void doFilter_noToken_noAuthentication() throws ServletException, IOException {
        filter.doFilterInternal(request, response, filterChain);

        assertNull(SecurityContextHolder.getContext().getAuthentication());
        verify(filterChain).doFilter(request, response);
    }

    @Test
    @DisplayName("空Authorization头 - 不设置认证信息")
    void doFilter_emptyAuthHeader_noAuthentication() throws ServletException, IOException {
        request.addHeader("Authorization", "");

        filter.doFilterInternal(request, response, filterChain);

        assertNull(SecurityContextHolder.getContext().getAuthentication());
    }

    // ==================== 无效Token场景 ====================

    @Test
    @DisplayName("无效Token - 清除SecurityContext，继续过滤链")
    void doFilter_invalidToken_clearContext() throws ServletException, IOException {
        request.addHeader("Authorization", "Bearer invalidtoken");
        when(tokenService.validateToken("invalidtoken")).thenReturn(false);

        filter.doFilterInternal(request, response, filterChain);

        assertNull(SecurityContextHolder.getContext().getAuthentication());
        verify(filterChain).doFilter(request, response);
    }

    // ==================== 有效Token场景 ====================

    @Test
    @DisplayName("有效Token带权限 - 正确设置认证信息")
    void doFilter_validTokenWithPerms_setsAuthentication() throws ServletException, IOException {
        String token = "validtoken";
        request.addHeader("Authorization", "Bearer " + token);

        Claims claims = new DefaultClaims();
        claims.setSubject("1");
        claims.put("username", "admin");
        claims.put("permissions", Arrays.asList("system:user:list", "system:role:list"));

        when(tokenService.validateToken(token)).thenReturn(true);
        when(tokenService.parseToken(token)).thenReturn(claims);
        when(tokenService.refreshToken(token)).thenReturn(token);

        filter.doFilterInternal(request, response, filterChain);

        assertNotNull(SecurityContextHolder.getContext().getAuthentication());
        LoginUserDetails userDetails = (LoginUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        assertEquals("admin", userDetails.getUsername());
        assertEquals(1L, userDetails.getUserId());
    }

    @Test
    @DisplayName("有效Token无权限 - 从UserDetailsService重新加载")
    void doFilter_validTokenNoPerms_reloadFromUserDetailsService() throws ServletException, IOException {
        String token = "validtoken";
        request.addHeader("Authorization", "Bearer " + token);

        Claims claims = new DefaultClaims();
        claims.setSubject("1");
        claims.put("username", "admin");
        // 不设置permissions，模拟JWT中无权限

        Set<String> permissions = new HashSet<>(Arrays.asList("system:user:list", "ROLE_admin"));
        LoginUserDetails mockUserDetails = new LoginUserDetails(1L, "admin", "", 1, permissions);

        when(tokenService.validateToken(token)).thenReturn(true);
        when(tokenService.parseToken(token)).thenReturn(claims);
        when(tokenService.refreshToken(token)).thenReturn(token);
        when(userDetailsService.loadUserByUsername("admin")).thenReturn(mockUserDetails);

        filter.doFilterInternal(request, response, filterChain);

        assertNotNull(SecurityContextHolder.getContext().getAuthentication());
        verify(userDetailsService).loadUserByUsername("admin");

        LoginUserDetails userDetails = (LoginUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Set<String> authNames = new HashSet<>();
        for (GrantedAuthority auth : userDetails.getAuthorities()) {
            authNames.add(auth.getAuthority());
        }
        assertTrue(authNames.contains("system:user:list"));
        assertTrue(authNames.contains("ROLE_admin"));
    }

    @Test
    @DisplayName("有效Token无权限且UserDetailsService返回null - 无权限认证")
    void doFilter_validTokenNoPermsAndNullUserDetailsService_noAuthorities() throws ServletException, IOException {
        String token = "validtoken";
        request.addHeader("Authorization", "Bearer " + token);

        Claims claims = new DefaultClaims();
        claims.setSubject("1");
        claims.put("username", "admin");

        when(tokenService.validateToken(token)).thenReturn(true);
        when(tokenService.parseToken(token)).thenReturn(claims);
        when(tokenService.refreshToken(token)).thenReturn(token);
        when(userDetailsService.loadUserByUsername("admin")).thenReturn(null);

        filter.doFilterInternal(request, response, filterChain);

        assertNotNull(SecurityContextHolder.getContext().getAuthentication());
        LoginUserDetails userDetails = (LoginUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        assertTrue(userDetails.getAuthorities().isEmpty());
    }

    // ==================== Token解析异常场景 ====================

    @Test
    @DisplayName("Token解析异常 - 清除SecurityContext，继续过滤链")
    void doFilter_tokenParseException_clearsContext() throws ServletException, IOException {
        String token = "badtoken";
        request.addHeader("Authorization", "Bearer " + token);

        when(tokenService.validateToken(token)).thenReturn(true);
        when(tokenService.parseToken(token)).thenThrow(new RuntimeException("JWT expired"));

        filter.doFilterInternal(request, response, filterChain);

        assertNull(SecurityContextHolder.getContext().getAuthentication());
        verify(filterChain).doFilter(request, response);
    }

    // ==================== Token提取测试 ====================

    @Test
    @DisplayName("Bearer Token正确提取")
    void doFilter_bearerToken_correctlyExtracted() throws ServletException, IOException {
        String token = "mytoken123";
        request.addHeader("Authorization", "Bearer " + token);

        when(tokenService.validateToken(token)).thenReturn(false);

        filter.doFilterInternal(request, response, filterChain);

        verify(tokenService).validateToken(token);
    }

    @Test
    @DisplayName("非Bearer前缀Token - 作为原始Token处理")
    void doFilter_nonBearerToken_treatedAsRawToken() throws ServletException, IOException {
        String token = "rawtoken123";
        request.addHeader("Authorization", token);

        when(tokenService.validateToken(token)).thenReturn(false);

        filter.doFilterInternal(request, response, filterChain);

        verify(tokenService).validateToken(token);
    }

    // ==================== 权限类型测试 ====================

    @Test
    @DisplayName("JWT中permissions为空列表 - 触发从UserDetailsService重新加载")
    void doFilter_emptyPermissionsList_reloadFromService() throws ServletException, IOException {
        String token = "validtoken";
        request.addHeader("Authorization", "Bearer " + token);

        Claims claims = new DefaultClaims();
        claims.setSubject("2");
        claims.put("username", "user01");
        claims.put("permissions", Collections.emptyList());

        Set<String> permissions = new HashSet<>(Arrays.asList("system:dept:list", "ROLE_user"));
        LoginUserDetails mockUserDetails = new LoginUserDetails(2L, "user01", "", 1, permissions);

        when(tokenService.validateToken(token)).thenReturn(true);
        when(tokenService.parseToken(token)).thenReturn(claims);
        when(tokenService.refreshToken(token)).thenReturn(token);
        when(userDetailsService.loadUserByUsername("user01")).thenReturn(mockUserDetails);

        filter.doFilterInternal(request, response, filterChain);

        verify(userDetailsService).loadUserByUsername("user01");
        LoginUserDetails userDetails = (LoginUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        assertEquals(2, userDetails.getAuthorities().size());
    }
}
