package com.aladdin.common.core.exception;

import lombok.Getter;

/**
 * 系统异常
 *
 * @author cles
 * @date 2026/04/30
 */
@Getter
public class SystemException extends RuntimeException {

    private final int code;

    public SystemException(String message) {
        super(message);
        this.code = GlobalErrorCode.INTERNAL_ERROR.getCode();
    }

    public SystemException(int code, String message) {
        super(message);
        this.code = code;
    }

    public SystemException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
    }

    public SystemException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }
}
