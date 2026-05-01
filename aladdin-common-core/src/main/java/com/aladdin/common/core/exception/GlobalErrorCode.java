package com.aladdin.common.core.exception;

import lombok.Getter;

/**
 * 全局错误码枚举
 *
 * @author cles
 * @date 2026/04/30
 */
@Getter
public enum GlobalErrorCode implements ErrorCode {

    SUCCESS(200, "操作成功"),
    FAIL(500, "操作失败"),
    UNAUTHORIZED(401, "未认证"),
    FORBIDDEN(403, "无权限"),
    NOT_FOUND(404, "资源不存在"),
    BAD_REQUEST(400, "请求参数错误"),
    METHOD_NOT_ALLOWED(405, "请求方法不允许"),
    TOO_MANY_REQUESTS(429, "请求过于频繁"),
    INTERNAL_ERROR(50000, "系统内部错误"),
    PARAM_VALID_ERROR(10001, "参数校验失败"),
    REPEAT_SUBMIT(10002, "重复提交"),
    BUSINESS_ERROR(10003, "业务处理异常");

    private final int code;
    private final String msg;

    GlobalErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
