package com.aladdin.mis.identity.service;

public interface VerificationCodeService {

    boolean sendSmsCode(String phone, String sessionId, String prefix);
}
