package com.aladdin.auth.controller;

import com.aladdin.common.core.domain.R;
import com.aladdin.common.core.exception.GlobalErrorCode;
import com.aladdin.common.core.utils.IpUtil;
import com.aladdin.common.core.utils.ServletUtil;
import com.aladdin.common.security.entity.LoginLog;
import com.aladdin.common.security.log.LoginLogService;
import com.aladdin.common.security.service.LoginUserDetails;
import com.aladdin.common.security.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 认证控制器
 *
 * @author cles
 * @date 2026/05/08
 */
@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired(required = false)
    private LoginLogService loginLogService;

    @PostMapping("/login")
    public R<Map<String, Object>> login(@RequestBody Map<String, String> loginBody) {
        String username = loginBody.get("username");
        String password = loginBody.get("password");

        Authentication authentication;
        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(username, password);
            authentication = authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException e) {
            log.error("登录失败-密码错误: {}", e.getMessage());
            saveLoginLog(username, null, "0", GlobalErrorCode.LOGIN_PASSWORD_ERROR.getCode(), GlobalErrorCode.LOGIN_PASSWORD_ERROR.getMsg());
            return R.fail(GlobalErrorCode.LOGIN_PASSWORD_ERROR);
        } catch (Exception e) {
            saveLoginLog(username, null, "0", GlobalErrorCode.LOGIN_FAIL_ERROR.getCode(), e.getMessage());
            log.error("登录失败-异常: ", e);
            return R.fail(GlobalErrorCode.LOGIN_FAIL_ERROR);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        LoginUserDetails loginUser = (LoginUserDetails) authentication.getPrincipal();

        Map<String, Object> claims = new HashMap<>();
        claims.put("authorities", loginUser.getAuthorities().toString());
        String token = tokenService.createToken(loginUser.getUserId(), loginUser.getUsername(), claims);

        Map<String, Object> data = new HashMap<>();
        data.put("token", token);
        data.put("userId", loginUser.getUserId());
        data.put("username", loginUser.getUsername());

        saveLoginLog(username, loginUser.getUserId(), "1", GlobalErrorCode.LOGIN_SUCCESS.getCode(), "登录成功");
        return R.ok("登录成功", data);
    }

    @PostMapping("/logout")
    public R<Void> logout(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof LoginUserDetails) {
            LoginUserDetails loginUser = (LoginUserDetails) authentication.getPrincipal();
            tokenService.removeToken(loginUser.getUserId());
            saveLoginLog(loginUser.getUsername(), loginUser.getUserId(), "2", GlobalErrorCode.LOGIN_SUCCESS.getCode(), "登出成功");
        }
        SecurityContextHolder.clearContext();
        return R.ok("登出成功", null);
    }

    @RequestMapping("/userInfo")
    public R<Map<String, Object>> userInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof LoginUserDetails) {
            LoginUserDetails loginUser = (LoginUserDetails) authentication.getPrincipal();
            Map<String, Object> data = new HashMap<>();
            data.put("userId", loginUser.getUserId());
            data.put("username", loginUser.getUsername());
            data.put("authorities", loginUser.getAuthorities());
            return R.ok(data);
        }
        return R.fail("未登录");
    }

    private void saveLoginLog(String loginName, Long userId, String loginType, int code, String message) {
        if (loginLogService == null) {
            return;
        }
        LoginLog loginLog = new LoginLog();
        loginLog.setTraceId(UUID.randomUUID().toString().replace("-", ""));
        loginLog.setLoginName(loginName);
        loginLog.setLoginType(loginType);
        loginLog.setCode(code);
        loginLog.setMessage(message);
        loginLog.setLoginTime(LocalDateTime.now());
        if (userId != null) {
            loginLog.setUserId(userId.intValue());
        }
        HttpServletRequest request = ServletUtil.getRequest();
        if (request != null) {
            loginLog.setLoginIp(IpUtil.getIpAddr(request));
            loginLog.setSessionId(request.getSession().getId());
        }
        try {
            loginLogService.save(loginLog);
        } catch (Exception e) {
            log.warn("保存登录日志失败: {}", e.getMessage());
        }
    }
}
