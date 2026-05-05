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
 * 陪聊员
 * @author cles
 * @date 2024-09-02 00:20:02
*/
@Table("chat_acc_user_apply")
@Data
public class ChatAccUserApply extends GlobalModel {

    /**
     * userId
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * age年龄
     */
    @TableField("age")
    private Integer age;

    /**
     * sex性别
     */
    @TableField("sex")
    private Integer sex;

    /**
     * nickName
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * accPic用户头像
     */
    @TableField("acc_pic")
    private String accPic;

    /**
     * backPic背景图
     */
    @TableField("back_pic")
    private String backPic;

    /**
     * star星级
     */
    @TableField("star")
    private Integer star;

    /**
     * introduce自我介绍
     */
    @TableField("introduce")
    private String introduce;

    /**
     * voice声音自我介绍
     */
    @TableField("voice")
    private String voice;

    /**
     * joinTime加入时间
     */
    @TableField("join_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime joinTime;

    /**
     * status状态
     */
    @TableField("status")
    private Integer status;

    /**
     * timeType时间类型 1 按分钟 2 按小时 3 包月 4 长期 5 其他
     */
    @TableField("time_type")
    private Integer timeType;

    /**
     * price收费
     */
    @TableField("price")
    private Integer price;

    /**
     * timeSlot时间区间
     */
    @TableField("time_slot")
    private String timeSlot;

    /**
     * applyStatus申请状态
     */
    @TableField("apply_status")
    private Integer applyStatus;

    /**
     * applyTime
     */
    @TableField("apply_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime applyTime;

    /**
     * applyMessage申请信息
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
