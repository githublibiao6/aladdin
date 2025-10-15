package com.aladdin.mis.common.exception;

import com.aladdin.mis.common.enums.BussinessExceptionEnum;

/**
 * 业务报错
 */
public class BussinessException extends RuntimeException{

    /**
     * 错误代码
     */
    private final Integer errorCode;

    /**
     * 错误信息
     */
    private final String errorMessage;

    public BussinessExceptionEnum bussinessExceptionEnum;

    public BussinessException(String msg, Throwable e) {
        super(msg, e);
        this.errorCode = -1;
        this.errorMessage = msg;
    }

    public BussinessException(String errorMessage) {
        super(errorMessage);
        this.errorCode =- 1;
        this.errorMessage = errorMessage;
    }

    public BussinessException(BussinessExceptionEnum bussinessExceptionEnum) {
        super(bussinessExceptionEnum.getMessage());
        this.bussinessExceptionEnum = bussinessExceptionEnum;
        this.errorCode = bussinessExceptionEnum.getCode();
        this.errorMessage = bussinessExceptionEnum.getMessage();
    }
}
