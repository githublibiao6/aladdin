package com.aladdin.mis.common.service;
/*
 *  Created by cles on 2022/4/18 20:13
 */

/**
 * @author cles
 * @description: 验证码
 * @Date 2022/4/18 20:13
 * @version: 1.0.0
 */

public interface VerificationCodeService {

    /**
     * 发送短信验证码
     * @param phone
     * @param prefix
     * @return
     */
    boolean sendSmsCode(String phone , String  sessionId, String prefix);
}
