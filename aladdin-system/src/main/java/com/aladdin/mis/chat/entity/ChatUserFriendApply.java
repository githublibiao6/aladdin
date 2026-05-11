package com.aladdin.mis.chat.entity;

import com.aladdin.common.db.annotation.Table;
import com.aladdin.common.db.annotation.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 好友申请
 * @author cles
 * @date 2025-02-20 23:27:04
*/
@Table("chat_user_friend_apply")
@Data
public class ChatUserFriendApply extends GlobalModel {

    /**
     * userId用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * friendId申请朋友id
     */
    @TableField("friend_id")
    private Integer friendId;

    /**
     * source朋友来源
     */
    @TableField("source")
    private Integer source;

    /**
     * applyStatus申请状："
     */
    @TableField("apply_status")
    private Integer applyStatus;

    /**
     * applyTime申请时间
     */
    @TableField("apply_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime applyTime;

    /**
     * applyMessage申请消息
     */
    @TableField("apply_message")
    private String applyMessage;

    /**
     * auditTime审核时间
     */
    @TableField("audit_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime auditTime;

    /**
     * auditStatus审核状："
     */
    @TableField("audit_status")
    private Integer auditStatus;

    /**
     * auditMsg审核意见
     */
    @TableField("audit_msg")
    private String auditMsg;

}
