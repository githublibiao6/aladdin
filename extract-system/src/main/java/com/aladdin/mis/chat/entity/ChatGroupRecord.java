package com.aladdin.mis.chat.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
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
 * @date 2024-08-30 00:19:17
*/
@Table("chat_group_record")
@Data
public class ChatGroupRecord extends GlobalModel {

    /**
     * groupId组群id
     */
    @TableField("group_id")
    private Integer groupId;

    /**
     * groupUserId组员id
     */
    @TableField("group_user_id")
    private Integer groupUserId;

    /**
     * sendUser发送者id
     */
    @TableField("send_user")
    private Integer sendUser;

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
     * status消息状态
     */
    @TableField("status")
    private Integer status;

}
