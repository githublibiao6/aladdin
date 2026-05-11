package com.aladdin.common.security.sso;

import com.aladdin.common.security.entity.OmUser;

/**
 * SSO用户持有者
 *
 * @author cles
 * @date 2026/05/08
 */
public class SsoUserHolder {

    private static final ThreadLocal<OmUser> USER_HOLDER = new ThreadLocal<>();

    public static void setUser(OmUser user) {
        USER_HOLDER.set(user);
    }

    public static OmUser getUser() {
        return USER_HOLDER.get();
    }

    public static void clear() {
        USER_HOLDER.remove();
    }
}
