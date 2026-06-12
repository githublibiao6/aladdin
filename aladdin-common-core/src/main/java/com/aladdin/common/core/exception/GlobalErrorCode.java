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
    DATA_DUPLICATE(30003, "数据已存在"),
    LOGIN_SUCCESS(20000, "登录成功"),
    LOGIN_PASSWORD_ERROR(20012, "用户名或密码错误"),
    LOGIN_FAIL_ERROR(20013, "登录失败"),
    PASSWORD_SAME_AS_OLD(20014, "新密码不能与最近使用的密码相同"),
    PASSWORD_EXPIRED(20015, "密码已过期，请修改密码"),
    PASSWORD_FORCE_CHANGE(20016, "首次登录需修改密码"),
    ACCOUNT_LOCKED_BY_RETRY(20017, "密码错误次数过多，账号已锁定"),
    IP_BLACKLISTED(20018, "当前IP已被加入黑名单，无法访问"),
    IP_NOT_IN_WHITELIST(20019, "当前IP不在白名单中，无法访问"),
    OPEN_API_INVALID_AK(20020, "无效的AccessKey"),
    OPEN_API_INVALID_SK(20021, "签名验证失败"),
    OPEN_API_EXPIRED_TIMESTAMP(20022, "请求时间戳已过期"),
    OPEN_API_NONCE_DUPLICATE(20023, "请求已被处理，请勿重复提交"),
    OPEN_API_APP_DISABLED(20024, "API应用已被禁用"),
    OPEN_API_USER_NOT_BOUND(20025, "第三方账号未绑定系统用户"),
    TENANT_NOT_FOUND(20026, "租户不存在"),
    TENANT_DISABLED(20027, "租户已被禁用"),
    USER_GROUP_NOT_FOUND(20028, "用户组不存在");

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
