package com.aladdin.common.core.constant;

/**
 * Redis键常量
 *
 * @author cles
 * @date 2026/04/30
 */
public interface RedisKeyConstant {

    String PREFIX = "aladdin:";

    String LOGIN_TOKEN = PREFIX + "login:token:";
    String LOGIN_USER = PREFIX + "login:user:";
    String CAPTCHA = PREFIX + "captcha:";
    String RATE_LIMIT = PREFIX + "rate_limit:";
    String REPEAT_SUBMIT = PREFIX + "repeat_submit:";
    String SYS_CONFIG = PREFIX + "sys:config:";
    String SYS_DICT = PREFIX + "sys:dict:";
}
