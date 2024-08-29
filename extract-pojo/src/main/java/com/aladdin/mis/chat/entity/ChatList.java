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
 * 聊天列表
 * @author cles
 * @date 2024-08-30 00:19:46
*/
@Table("chat_list")
@Data
public class ChatList extends GlobalModel {

    /**
     * userId用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * chatKind聊天类别 1 单聊 2 群聊
     */
    @TableField("chat_kind")
    private Integer chatKind;

    /**
     * chatId聊天主键
     */
    @TableField("chat_id")
    private Integer chatId;

    /**
     * chatName显示名称
     */
    @TableField("chat_name")
    private String chatName;

    /**
     * unreadCount未读消息数量
     */
    @TableField("unread_count")
    private Integer unreadCount;

    /**
     * lastMessage最新一条消息
     */
    @TableField("last_message")
    private String lastMessage;

    /**
     * pictureUrl显示地址
     */
    @TableField("picture_url")
    private String pictureUrl;

    /**
     * sendTime发送时间
     */
    @TableField("send_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sendTime;

    /**
     * chatLabel特殊标签，（有新文件 @我， @全体）
     */
    @TableField("chat_label")
    private String chatLabel;

    /**
     * top是否置顶
     */
    @TableField("top")
    private Integer top;

    /**
     * status是否提示
     */
    @TableField("status")
    private Integer status;

    /**
     * chatLevel聊天等级
     */
    @TableField("chat_level")
    private Integer chatLevel;

    /**
     * interest是否特别关注
     */
    @TableField("interest")
    private Integer interest;

}
