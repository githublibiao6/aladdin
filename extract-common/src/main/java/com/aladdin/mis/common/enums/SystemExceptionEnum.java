package com.aladdin.mis.common.enums;

/**
 * 系统错误枚举
 */
public enum SystemExceptionEnum {

    SUCCESS(200, "成功"),
    UNKNOWN_ERROR(-1, "未知异常"),
    TABLE_NOT_EXIST(10100, "未知表异常"),
    TABLE_FIELD_VALUE(10101, "获取字段值异常"),
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

    private SystemExceptionEnum(final Integer code, final String message) {
        this.code = code;
        this.message = message;
    }
}
