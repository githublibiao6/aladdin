package com.aladdin.common.security.sso;

import com.aladdin.common.security.entity.OmUser;
import com.aladdin.common.security.redis.util.RedisUtil;
import com.alibaba.fastjson2.JSON;

public class SsoAuth {

    private static final String TOKEN_PREFIX = "sso:token:";
    private static final int TOKEN_EXPIRE_SECONDS = 1800;

    public static String generateToken(OmUser user) {
        String token = "om" + java.util.UUID.randomUUID().toString().replace("-", "");
        String key = TOKEN_PREFIX + token;
        String value = JSON.toJSONString(user);
        RedisUtil.setString(key, TOKEN_EXPIRE_SECONDS, value);
        return token;
    }

    public static OmUser verifyLogin(String token) {
        if (token == null || token.isEmpty()) {
            return null;
        }
        String key = TOKEN_PREFIX + token;
        String value = RedisUtil.getString(key);
        if (value == null || value.isEmpty()) {
            return null;
        }
        RedisUtil.setString(key, TOKEN_EXPIRE_SECONDS, value);
        return JSON.parseObject(value, OmUser.class);
    }

    public static boolean verifyAuth(String token) {
        OmUser user = verifyLogin(token);
        return user != null;
    }

    public static void removeToken(String token) {
        if (token != null && !token.isEmpty()) {
            String key = TOKEN_PREFIX + token;
            RedisUtil.setString(key, 0, "");
        }
    }

    public static void refreshToken(String token) {
        if (token != null && !token.isEmpty()) {
            String key = TOKEN_PREFIX + token;
            String value = RedisUtil.getString(key);
            if (value != null && !value.isEmpty()) {
                RedisUtil.setString(key, TOKEN_EXPIRE_SECONDS, value);
            }
        }
    }
}
