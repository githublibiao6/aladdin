package com.aladdin.mis.common.enums;

/**
 * 业务错误枚举
 */
public enum BussinessExceptionEnum {

    SUCCESS(200, "成功"),
    UNKNOWN_ERROR(-1, "未知异常"),
    ERROR(500, "失败");

    /**
     * 错误代码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String message;

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    private BussinessExceptionEnum(final Integer code, final String message) {
        this.code = code;
        this.message = message;
    }
}
