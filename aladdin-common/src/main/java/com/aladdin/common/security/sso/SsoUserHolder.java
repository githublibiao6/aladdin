package com.aladdin.common.security.sso;

import com.aladdin.common.security.entity.OmUser;

public class SsoUserHolder {

    private static final ThreadLocal<OmUser> USER_THREAD_LOCAL = new ThreadLocal<>();

    public static void setUser(OmUser user) {
        USER_THREAD_LOCAL.set(user);
    }

    public static OmUser getUser() {
        return USER_THREAD_LOCAL.get();
    }

    public static Integer getUserId() {
        OmUser user = getUser();
        return user != null ? user.getUserId() : null;
    }

    public static void remove() {
        USER_THREAD_LOCAL.remove();
    }
}
