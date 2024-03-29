package com.aladdin.mis.common.utils;

import com.aladdin.mis.system.user.vo.OmUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * d登录的用户
 * @author cles
 */
public  class UserUtil {

    /**
     * 获取当前用户
     * @return
     */
    public static OmUser getCurrentUser() {
        Subject subject = SecurityUtils.getSubject();
        if(subject != null){
            return (OmUser) subject.getPrincipal();
        }
        return null;
    }
}
