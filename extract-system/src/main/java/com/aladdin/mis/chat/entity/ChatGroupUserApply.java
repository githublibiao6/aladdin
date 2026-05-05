package com.aladdin.mis.chat.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 群-用户申请
 * @author cles
 * @date 2025-02-20 23:26:12
*/
@Table("chat_group_user_apply")
@Data
public class ChatGroupUserApply extends GlobalModel {

    /**
     * groupId群主键
     */
    @TableField("group_id")
    private Integer groupId;

    /**
     * userId用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * applyStatus申请状态
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
     * auditUser审核人
     */
    @TableField("audit_user")
    private Integer auditUser;

    /**
     * auditUserName审核人名称
     */
    @TableField("audit_user_name")
    private String auditUserName;

    /**
     * auditStatus审核状态
     */
    @TableField("audit_status")
    private Integer auditStatus;

    /**
     * auditMsg审核意见
     */
    @TableField("audit_msg")
    private String auditMsg;

}
