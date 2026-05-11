package com.aladdin.mis.identity.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.aladdin.common.core.constant.Parameter;
import com.aladdin.common.security.redis.RedisService;
import com.aladdin.mis.identity.sms.AliyunSms;
import com.aladdin.mis.identity.service.VerificationCodeService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    private final RedisService redisService;

    public VerificationCodeServiceImpl(RedisService redisService) {
        this.redisService = redisService;
    }

    @Override
    public boolean sendSmsCode(String phone, String sessionId, String prefix) {
        String code = RandomUtil.randomNumbers(6);
        redisService.set(Parameter.RESET_PASS_CODE_PREFIX + ":" + sessionId, code, 2, TimeUnit.MINUTES);
        try {
            return AliyunSms.sendSms(phone, code);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
