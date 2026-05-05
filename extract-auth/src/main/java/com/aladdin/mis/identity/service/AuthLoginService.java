package com.aladdin.mis.identity.service;

import com.aladdin.common.security.entity.LoginUser;
import com.aladdin.common.security.entity.OmUser;
import com.aladdin.mis.common.system.entity.Result;

public interface AuthLoginService {

    Result signIn(LoginUser user);

    Result signOut(OmUser user);
}
