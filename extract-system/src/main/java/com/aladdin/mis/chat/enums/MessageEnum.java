package com.aladdin.mis.chat.enums;

/**
 * 消息类型枚举
 * @author libia
 */
public enum MessageEnum {

    /**
     * 文字
     */
    CHARACTERS("CHARACTERS") ,

    /**
     * 图片
     */
    PICTURE("PICTURE"),

    /**
     * 链接
     */
    LINK("LINK")

    ;

    private String typeCode;

    MessageEnum(String typeCode){
        this.typeCode = typeCode;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }
}
