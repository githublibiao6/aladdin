package com.aladdin.mis.chat.enums;

/**
 * 消息类型枚举
 * @author libia
 */
public enum InfoEnum {

    /**
     * 对聊
     */
    PRIVATE_CHAT("PRIVATE_CHAT") ,

    /**
     * 群聊
     */
    GROUP_CHAT("GROUP_CHAT"),

    /**
     * 群申："
     */
    GROUP_APPLY("GROUP_APPLY"),

    /**
     * 好友申请
     */
    FRIEND_APPLY("FRIEND_APPLY")

    ;

    private String typeCode;

    InfoEnum(String typeCode){
        this.typeCode = typeCode;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }
}
