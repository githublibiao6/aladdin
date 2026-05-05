package com.aladdin.mis.shiro;

import com.aladdin.common.security.entity.OmUser;
import com.aladdin.common.security.sso.SsoUserHolder;

import java.util.HashMap;
import java.util.Map;

public class OmClient {

    public static Map<String, OmUser> userMap = new HashMap<>(256);

    public static void setUser() {
        OmUser user = SsoUserHolder.getUser();
        if (user != null) {
            userMap.put(user.getLoginName(), user);
        }
    }

    public static OmUser getCurrentUser() {
        OmUser user = SsoUserHolder.getUser();
        if (user != null) {
            return user;
        }
        return null;
    }

    public static OmUser getCurrentUser(String token) {
        return userMap.get(token);
    }
}
