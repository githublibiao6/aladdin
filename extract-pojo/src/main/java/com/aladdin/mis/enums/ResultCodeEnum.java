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
    FAIL(500, "服务器内部出错"),;


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
