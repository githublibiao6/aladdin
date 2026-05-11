package com.aladdin.mis.chat.entity;

import com.aladdin.common.db.annotation.Table;
import com.aladdin.common.db.annotation.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 聊天会话-两人对话
 * @author cles
 * @date 2025-02-20 23:26:41
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
     * toUser接收用户id
     */
    @TableField("to_user")
    private Integer toUser;

    /**
     * infoKind信息类别
     */
    @TableField("info_kind")
    private Integer infoKind;

    /**
     * message发送文字内："
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
     * sendTime发送时："
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
     * status消息状："："发送成："
     */
    @TableField("status")
    private Integer status;

    /**
     * createShow发送者是否显："
     */
    @TableField("create_show")
    private Integer createShow;

    /**
     * chatShow接受者是否显："
     */
    @TableField("chat_show")
    private Integer chatShow;

}
