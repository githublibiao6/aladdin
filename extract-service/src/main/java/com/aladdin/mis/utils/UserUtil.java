package com.aladdin.mis.utils;

import com.aladdin.mis.system.user.vo.OmUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

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
        Subject subject = SecurityUtils.getSubject();
        if(subject != null){
            return (OmUser) subject.getPrincipal();
        }
        OmUser om = new OmUser();
        om.setUserType("0");
        om.setUserId(0);
        om.setUserName("Mr.Nobody");
        om.setUserId(0);
        return om;
    }
}