package com.aladdin.common.core.exception;

import com.aladdin.common.core.enums.SystemExceptionEnum;

public class SystemException extends RuntimeException {

    private Integer code;

    public SystemException(String message) {
        super(message);
    }

    public SystemException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public SystemException(SystemExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
