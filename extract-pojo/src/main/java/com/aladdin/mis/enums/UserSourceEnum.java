package com.aladdin.mis.enums;

/**
 * 常见http响应代码枚举
 * @author libia
 */
public enum UserSourceEnum {
    /**
     * 常见http响应代码整理
     */
    WEB(1 ,"web注册") ,

    NOT_RESPONSE(2 ,"wechart注册"),

    GATEWAY_ERROR(3 ,"")

    ;

    private int code;
    private String desc;

    UserSourceEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
