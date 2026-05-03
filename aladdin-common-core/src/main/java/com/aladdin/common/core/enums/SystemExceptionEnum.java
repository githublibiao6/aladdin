package com.aladdin.common.core.enums;

public enum SystemExceptionEnum {

    UNKNOWN_ERROR(500, "未知异常"),
    PARAM_ERROR(400, "参数错误"),
    NOT_FOUND(404, "资源未找到"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问");

    private final Integer code;
    private final String message;

    SystemExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
