package com.aladdin.mis.chat.param;

import lombok.Data;

/**
 * 消息内容
 * @author mua
 */
@Data
public class ChatMessageParam {

    /**
     * 消息类别 InfoEnum
     */
    private String infoType;

    /**
     * 信息类别 MessageEnum
     */
    private String messageType;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 接收方id
     */
    private String acceptId;
}
