package com.aladdin.mis.common.enums;

/**
 * 常见http响应代码枚举
 * @author libia
 */
public enum HttpCode{
    /**
     * 常见http响应代码整理
     */
    SUCCESS(200 ,"请求成功") ,

    NOT_RESPONSE(202 ,"请求收到但未响应"),

    NOT_FOUND(404 ,"请求失败，请求资源找不到"),

    GATEWAY_ERROR(502 ,"网关错误")

    ;

    private int code;
    private String message;

    HttpCode(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}