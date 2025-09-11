package com.aladdin.mis.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;


/**
 * 字典 Service
 * @author lb
 *
 */
public interface AuthLoginService {

    /**
     * 用户登入
     * @param user
     * @return
     */
    JSONObject signIn(Map user);

    /**
     * 用户登出
     * @param user
     * @return
     */
//    Result signOut(OmUser user);
}
