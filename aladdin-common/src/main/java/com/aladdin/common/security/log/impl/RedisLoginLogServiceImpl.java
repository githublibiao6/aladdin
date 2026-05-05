package com.aladdin.common.security.log.impl;

import com.aladdin.common.security.entity.LoginLog;
import com.aladdin.common.security.log.LoginLogService;
import com.aladdin.common.security.redis.util.RedisUtil;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RedisLoginLogServiceImpl implements LoginLogService {

    private static final String LOGIN_LOG_KEY = "sso:log:login";

    @Override
    public void save(LoginLog loginLog) {
        try {
            String value = JSON.toJSONString(loginLog);
            RedisUtil.pushList(LOGIN_LOG_KEY, value);
        } catch (Exception e) {
            log.warn("保存登录日志失败: {}", e.getMessage());
        }
    }
}
