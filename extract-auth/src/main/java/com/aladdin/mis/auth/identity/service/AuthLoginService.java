package com.aladdin.mis.auth.identity.service;

import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.system.user.vo.LoginUser;
import com.aladdin.mis.system.user.vo.OmUser;


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
    Result signIn(LoginUser user);

    /**
     * 用户登出
     * @param user
     * @return
     */
    Result signOut(OmUser user);
}
