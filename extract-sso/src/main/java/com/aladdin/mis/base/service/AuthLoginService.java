package com.aladdin.mis.base.service;

import com.aladdin.mis.base.model.param.LoginUser;
import com.alibaba.fastjson.JSONObject;


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
    JSONObject signIn(LoginUser user);

    /**
     * 用户登出
     * @param user
     * @return
     */
//    Result signOut(OmUser user);
}
