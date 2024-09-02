package com.aladdin.mis.chat.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 聊天会话-两人对话
 * @author cles
 * @date 2024-08-30 00:19:56
*/
@Table("chat_record")
@Data
public class ChatRecord extends GlobalModel {

    /**
     * sendUser发送者id
     */
    @TableField("send_user")
    private Integer sendUser;

    /**
     * receiveUser接收用户id
     */
    @TableField("to_user")
    private Integer toUser;

    /**
     * infoKind信息类别
     */
    @TableField("info_kind")
    private Integer infoKind;

    /**
     * message发送文字内容
     */
    @TableField("message")
    private String message;

    /**
     * pictureUrl图片地址
     */
    @TableField("picture_url")
    private String pictureUrl;

    /**
     * voiceUrl语音消息
     */
    @TableField("voice_url")
    private String voiceUrl;

    /**
     * emoji
     */
    @TableField("emoji")
    private String emoji;

    /**
     * fileUrl文件地址
     */
    @TableField("file_url")
    private String fileUrl;

    /**
     * sendTime发送时间
     */
    @TableField("send_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sendTime;

    /**
     * chatSessionId聊天会话
     */
    @TableField("chat_session_id")
    private Integer chatSessionId;

    /**
     * status消息状态 ？ 发送成功
     */
    @TableField("status")
    private Integer status;

    /**
     * createShow发送者是否显示
     */
    @TableField("create_show")
    private Integer createShow;

    /**
     * chatShow接受者是否显示
     */
    @TableField("chat_show")
    private Integer chatShow;

}
