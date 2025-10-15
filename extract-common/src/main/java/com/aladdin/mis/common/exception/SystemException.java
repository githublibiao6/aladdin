package com.aladdin.mis.common.exception;

import com.aladdin.mis.common.enums.SystemExceptionEnum;

/**
 * 系统内部报错
 */
public class SystemException extends RuntimeException{

    /**
     * 错误代码
     */
    private final Integer errorCode;

    /**
     * 错误信息
     */
    private final String errorMessage;

    public SystemExceptionEnum systemExceptionEnum;

    public SystemException(String msg, Throwable e) {
        super(msg, e);
        this.errorCode = -1;
        this.errorMessage = msg;
    }

    public SystemException(String errorMessage) {
        super(errorMessage);
        this.errorCode =- 1;
        this.errorMessage = errorMessage;
    }

    public SystemException(SystemExceptionEnum systemExceptionEnum) {
        super(systemExceptionEnum.getMessage());
        this.systemExceptionEnum = systemExceptionEnum;
        this.errorCode = systemExceptionEnum.getCode();
        this.errorMessage = systemExceptionEnum.getMessage();
    }
}
