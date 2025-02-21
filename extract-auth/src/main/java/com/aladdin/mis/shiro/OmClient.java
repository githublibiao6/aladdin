package com.aladdin.mis.shiro;
/*
 *  Created by cles on 2023/2/2 23:34
 */

import com.aladdin.mis.system.user.vo.OmUser;
import org.apache.shiro.SecurityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cles
 * @description: 用户的设置
 * @Date 2023/2/2 23:34
 * @version: 1.0.0
 */
public class OmClient {

    /**
     * 存储接入的客户端的channel对象
     */
    public static Map<String, OmUser> userMap = new HashMap<>(256);


    /**
     * 获取当前用户
     * @return
     */
    public static void setUser(){
        userMap.put((String)SecurityUtils.getSubject().getSession().getId()
                , (OmUser) SecurityUtils.getSubject().getPrincipal());
    }

    /**
     * 获取当前用户
     * @return
     */
    public static OmUser getCurrentUser(){
        return (OmUser) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 获取当前用户
     * @return
     */
    public static OmUser getCurrentUser(String token){
        return userMap.get(token);
    }
}
