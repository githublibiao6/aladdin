package com.aladdin.mis.identity.service.impl;

import com.aladdin.common.core.utils.IpUtil;
import com.aladdin.common.core.utils.ServletUtil;
import com.aladdin.common.security.entity.LoginLog;
import com.aladdin.common.security.entity.LoginUser;
import com.aladdin.common.security.entity.OmUser;
import com.aladdin.common.security.log.LoginLogService;
import com.aladdin.common.security.sso.SsoAuth;
import com.aladdin.mis.identity.service.AuthLoginService;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.shiro.OmClient;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AuthLoginServiceImpl implements AuthLoginService {

    @Autowired(required = false)
    private LoginLogService loginLogService;

    @Override
    public Result signIn(LoginUser user) {
        Result result = new Result();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        try {
            subject.login(token);
        } catch (AccountException accountException) {
            saveLoginLog(user.getUserName(), null, "0", 10001, accountException.getMessage());
            result.setMessage(accountException.getMessage());
            result.setSuccess(false);
            result.setCode(10001);
            return result;
        } catch (Exception e) {
            saveLoginLog(user.getUserName(), null, "0", 10001, "登录失败");
            result.setMessage("登录失败");
            result.setSuccess(false);
            result.setCode(10001);
            return result;
        }

        OmUser omUser = OmClient.getCurrentUser();
        String ssoToken = SsoAuth.generateToken(omUser);
        omUser.setToken(ssoToken);
        OmClient.setUser();

        subject.getSession().setTimeout(1000 * 60 * 30);
        result.setData(ssoToken);
        result.setCode(20000);

        saveLoginLog(omUser.getLoginName(), omUser, "1", 20000, "登录成功");
        return result;
    }

    @Override
    public Result signOut(OmUser user) {
        if (user != null && user.getToken() != null) {
            SsoAuth.removeToken(user.getToken());
            saveLoginLog(user.getLoginName(), user, "2", 20000, "登出成功");
        }
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        Result result = new Result();
        result.setCode(20000);
        result.setMessage("登出成功");
        return result;
    }

    private void saveLoginLog(String loginName, OmUser omUser, String loginType, int code, String message) {
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

        if (omUser != null) {
            loginLog.setUserId(omUser.getUserId());
            loginLog.setUserName(omUser.getUserName());
        }

        HttpServletRequest request = ServletUtil.getRequest();
        if (request != null) {
            loginLog.setLoginIp(IpUtil.getIpAddr(request));
            loginLog.setSessionId(request.getSession().getId());
        }

        try {
            loginLogService.save(loginLog);
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(AuthLoginServiceImpl.class)
                    .warn("保存登录日志失败: {}", e.getMessage());
        }
    }
}
