package com.aladdin.mis.identity.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.aladdin.common.core.constant.Parameter;
import com.aladdin.common.security.redis.util.RedisUtil;
import com.aladdin.mis.identity.sms.AliyunSms;
import com.aladdin.mis.identity.service.VerificationCodeService;
import org.springframework.stereotype.Service;

@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Override
    public boolean sendSmsCode(String phone, String sessionId, String prefix) {
        String code = RandomUtil.randomNumbers(6);
        RedisUtil.setString(Parameter.RESET_PASS_CODE_PREFIX + ":" + sessionId, 60 * 2, code);
        try {
            boolean flag = AliyunSms.sendSms(phone, code);
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
