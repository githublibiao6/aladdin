package com.aladdin.mis.enums;

/*
 *  Created by cles on 2021/8/16 22:14
 */

/**
 * @author libia
 */

public enum ResultCodeEnum {

    /**
     * 返回结果code
     * 已使用
     */
    SUCCESS(20000, "后台处理成功"),
    FAIL(50000, "服务器内部出错"),
//    尚未使用的code
    FAIL_NOT_IMPLEMENTED(5001, "服务器不支持当前请求的功能"),
    FAIL_BAD_GATEWAY(5002, "服务器接无效的响应"),
    FAIL_SERVICE_UNAVAILABLE(5003, "服务器不可用"),
    FAIL_GATEWAY_TIMEOUT(5004, "网关超时"),
    FAIL_HTTP_VERSION_NOT_SUPPORTED(5005, "不支持的http版本"),
    FAIL_VARIANT_ALSO_NEGOTIATES(5006, "服务器内部配置错误"),
    FAIL_INSUFFICIENT_STORAGE(5007, "服务器无法存储完成请求所必须的内容"),
    FAIL_BANDWIDTH_LIMIT_EXCEEDED(5009, "服务器达到带宽限制"),
    FAIL_NOT_EXTENDED(5010, "获取资源所需要的策略并没有被满足"),
    FAIL_FRAMEWORK_ERROR(5100, "未分类的框架错误"),
    FAIL_FRAMEWORK_NO_ID_FIELD(5101, "实体中不包含id字段,不能进行get,removeById等操作"),
    FAIL_FRAMEWORK_NO_ACTIVE_FIELD(5102, "实体中不包含active字段,不能进行逻辑删除，恢复等操作"),
    FAIL_FRAMEWORK_NO_SUCH_FIELD(5103, "实体中不包含当前字段"),
    FAIL_FRAMEWORK_NOT_LOGGED_IN(5104, "用户未登录"),
    FAIL_FRAMEWORK_NOT_LOGGED_IN_BUT_RETURN(5105, "用户未登录，返回空数据，请登录之后再次尝试获取"),
    FAIL_FRAMEWORK_SESSION_TIMEOUT(5106, "session超时退出"),
    FAIL_FRAMEWORK_USER_NOT_EXIST(5107, "用户不存在"),
    FAIL_FRAMEWORK_USERNAME_OR_PASSWORD_NOT_CORRECT(5108, "用户名或密码不正确"),
    FAIL_FRAMEWORK_SECURITY_NOT_ENABLE(5109, "后台框架未开启安全功能"),
    FAIL_FRAMEWORK_CONDITION_VALIDATE(5110, "Condition参数校验失败"),
    FAIL_SYSTEM_ERROR(5200, "系统错误，未知的错误!"),
    FAIL_SYSTEM_FILE_NOT_FOUND(5201, "文件没有找到，请确认文件位置！"),
    FAIL_SYSTEM_NUMBER_FORMAT(5202, "字符串转换数字出错了!"),
    FAIL_SYSTEM_SQL_EXCEPTION(5203, "操作数据库出错了!"),
    FAIL_SYSTEM_ILLEGAL_ARGUMENT(5204, "传递的参数出错了！"),
    FAIL_SYSTEM_STACK_OVERFLOW(5205, "栈溢出了！"),
    FAIL_SYSTEM_NO_HANDLER(5206, "未找到实现方法（spring）"),
    FAIL_SYSTEM_BAD_REQUEST(5207, "Bad Request!"),
    FAIL_SYSTEM_METHOD_NOT_ALLOWED(5208, "Method Not Allowed! 有可能是接口类型错误！"),
    FAIL_SYSTEM_INTERNAL_SERVER_ERROR(5209, "Internal Server Error"),
    FAIL_SYSTEM_RESOURCE_NOT_FOUND(5210, "资源没有找到"),
    FAIL_SYSTEM_INDEX_OUT_BOUNDS(5211, "数组越界了！"),
    FAIL_SYSTEM_NULL_POINTER(5212, "空指针异常！"),
    FAIL_SYSTEM_IO_EXCEPTION(5213, "IO异常！"),
    FAIL_SYSTEM_NO_SUCH_METHOD(5214, "找不到方法，未知的方法"),
    FAIL_SYSTEM_CLASS_CAST(5215, "类型转换出错，请检查"),
    FAIL_SYSTEM_CUSTOMIZE_EXCEPTION(5216, "自定义异常，请检查"),
    FAIL_SYSTEM_ILLEGAL_PARAMETER(5217, "请求参数错误不合法"),
    FAIL_SYSTEM_METHOD_ILLEGAL_PARAMETER(5218, "请求方法参数错误不合法");


    private String msg;
    private Integer code;

    private ResultCodeEnum(int code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
