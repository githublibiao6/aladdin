package com.aladdin.common.core.domain;

import com.aladdin.common.core.exception.ErrorCode;
import com.aladdin.common.core.exception.GlobalErrorCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * 统一响应实体
 *
 * @author cles
 * @date 2026/04/30
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class R<T> implements Serializable {

    private int code;
    private String msg;
    private T data;
    /** 前端兼容字段：提示信息 */
    private String message;
    /** 前端兼容字段：错误信息（成功时为null） */
    private Object error;

    public R() {
    }

    public R(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.message = msg;
        this.error = code == GlobalErrorCode.SUCCESS.getCode() ? null : msg;
    }

    public static <T> R<T> ok() {
        return new R<>(GlobalErrorCode.SUCCESS.getCode(), GlobalErrorCode.SUCCESS.getMsg(), null);
    }

    public static <T> R<T> ok(T data) {
        return new R<>(GlobalErrorCode.SUCCESS.getCode(), GlobalErrorCode.SUCCESS.getMsg(), data);
    }

    public static <T> R<T> ok(String msg, T data) {
        return new R<>(GlobalErrorCode.SUCCESS.getCode(), msg, data);
    }

    public static <T> R<T> fail() {
        return new R<>(GlobalErrorCode.FAIL.getCode(), GlobalErrorCode.FAIL.getMsg(), null);
    }

    public static <T> R<T> fail(String msg) {
        return new R<>(GlobalErrorCode.FAIL.getCode(), msg, null);
    }

    public static <T> R<T> fail(int code, String msg) {
        return new R<>(code, msg, null);
    }

    public static <T> R<T> fail(ErrorCode errorCode) {
        return new R<>(errorCode.getCode(), errorCode.getMsg(), null);
    }

    public static <T> R<T> fail(ErrorCode errorCode, String msg) {
        return new R<>(errorCode.getCode(), msg, null);
    }

    public boolean isSuccess() {
        return this.code == GlobalErrorCode.SUCCESS.getCode();
    }
}
