package com.aladdin.common.security.log;

import com.aladdin.common.security.entity.LoginLog;

public interface LoginLogService {

    void save(LoginLog loginLog);
}
