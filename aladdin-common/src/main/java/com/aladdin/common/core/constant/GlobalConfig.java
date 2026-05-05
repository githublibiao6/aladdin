package com.aladdin.common.core.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GlobalConfig {

    @Value("${global.verify.enable:false}")
    public static boolean verifyEnable;

    @Value("${global.verify.enable:false}")
    public boolean verifyEnable1;

    @Value("${global.verify.code:false}")
    public static boolean verifyCode;

    @Value("${global.verify.sms:false}")
    public static boolean verifySms;

    public static boolean isVerifyEnable() {
        return verifyEnable;
    }

    public static void setVerifyEnable(boolean verifyEnable) {
        GlobalConfig.verifyEnable = verifyEnable;
    }

    public static boolean isVerifyCode() {
        return verifyCode;
    }

    public static void setVerifyCode(boolean verifyCode) {
        GlobalConfig.verifyCode = verifyCode;
    }

    public static boolean isVerifySms() {
        return verifySms;
    }

    public static void setVerifySms(boolean verifySms) {
        GlobalConfig.verifySms = verifySms;
    }

    public boolean getVerifyEnable1() {
        return verifyEnable1;
    }

    public void setVerifyEnable1(boolean verifyEnable1) {
        this.verifyEnable1 = verifyEnable1;
    }
}
