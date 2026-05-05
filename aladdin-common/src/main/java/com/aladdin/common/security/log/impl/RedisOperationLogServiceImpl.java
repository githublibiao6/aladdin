package com.aladdin.common.security.log.impl;

import com.aladdin.common.security.entity.OperationLog;
import com.aladdin.common.security.log.OperationLogService;
import com.aladdin.common.security.redis.util.RedisUtil;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RedisOperationLogServiceImpl implements OperationLogService {

    private static final String OPERATION_LOG_KEY = "sso:log:operation";

    @Override
    public void save(OperationLog operationLog) {
        try {
            String value = JSON.toJSONString(operationLog);
            RedisUtil.pushList(OPERATION_LOG_KEY, value);
        } catch (Exception e) {
            log.warn("保存操作日志失败: {}", e.getMessage());
        }
    }
}
