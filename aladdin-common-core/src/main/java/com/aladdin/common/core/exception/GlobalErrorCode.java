package com.aladdin.common.core.exception;

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
    BUSINESS_ERROR(10003, "业务处理异常"),
    TOKEN_INVALID(20001, "Token无效"),
    TOKEN_EXPIRED(20002, "Token已过期"),
    TOKEN_MISSING(20003, "缺少Token"),
    LOGIN_FAIL(20004, "登录失败"),
    LOGIN_EXPIRED(20005, "登录已过期"),
    ACCOUNT_DISABLED(20006, "账号已被禁用"),
    ACCOUNT_LOCKED(20007, "账号已被锁定"),
    CAPTCHA_ERROR(20008, "验证码错误"),
    CAPTCHA_EXPIRED(20009, "验证码已过期"),
    PASSWORD_ERROR(20010, "密码错误"),
    USER_NOT_FOUND(20011, "用户不存在"),
    DATA_PERMISSION_DENIED(30001, "无数据权限"),
    DATA_NOT_FOUND(30002, "数据不存在"),
    DATA_DUPLICATE(30003, "数据已存在");

    private final int code;
    private final String msg;

    GlobalErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
