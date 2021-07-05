package com.apps.omnipotent.system.utils;
/*
 *  Created by cles on 2020/6/20 21:57
 */

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

/**
 * @author cles
 * @description: session相关工具
 * @Date 2020/6/20 21:57
 * @version: 1.0.0
 */
public class SessionUtils {

    public static String getUserId(){
        Session session = SecurityUtils.getSubject().getSession();
        String userId = (String) session.getAttribute("userId");
        return userId;

    }
}
