package com.aladdin.mis.common.service.impl;
/*
 *  Created by cles on 2022/4/18 20:14
 */

import cn.hutool.core.util.RandomUtil;
import com.aladdin.mis.common.currency.Parameter;
import com.aladdin.mis.common.redis.config.JedisUtil;
import com.aladdin.mis.common.service.VerificationCodeService;
import com.aladdin.mis.common.sms.AliyunSms;
import org.springframework.stereotype.Service;

/**
 * @author cles
 * @description: 验证码
 * @Date 2022/4/18 20:14
 * @version: 1.0.0
 */
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Override
    public boolean sendSmsCode(String phone, String  sessionId, String prefix) {
        // 生成6位验证码
        String code = RandomUtil.randomNumbers(6);
        // 将验证码放入redis缓存， 等待验证
        JedisUtil.setString(Parameter.RESET_PASS_CODE_PREFIX+":"+ sessionId , 60 * 2 , code);
        try {
            boolean flag = AliyunSms.sendSms(phone, code);
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
