package com.aladdin.mis.utils;

import com.aladdin.common.security.entity.OmUser;

//import javax.security.auth.Subject;

/**
 * 登录的用户
 * @author cles
 */
public  class UserUtil {

    /**
     * 获取当前用户
     * @return user
     */
    public static OmUser getCurrentUser() {
//        Subject subject = SecurityUtils.getSubject();
//        if(subject != null && subject.getPrincipal() != null){
//            return (OmUser) subject.getPrincipal();
//        }
        OmUser om = new OmUser();
        om.setUserType("0");
        om.setUserId(0);
        om.setUserName("Mr.Nobody");
        om.setUserId(0);
        return om;
    }
}
