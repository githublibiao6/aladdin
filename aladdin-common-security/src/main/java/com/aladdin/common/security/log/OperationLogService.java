package com.aladdin.common.security.log;

import com.aladdin.common.security.entity.OperationLog;

public interface OperationLogService {

    void save(OperationLog operationLog);
}
