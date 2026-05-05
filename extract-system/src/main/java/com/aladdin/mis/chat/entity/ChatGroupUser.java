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
 * 聊天记录-两人对话
 * @author cles
 * @date 2024-08-30 00:19:29
*/
@Table("chat_group_user")
@Data
public class ChatGroupUser extends GlobalModel {

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
     * joinTime加入时间
     */
    @TableField("join_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime joinTime;

    /**
     * role群员角色 1 群主 2 管理 3 组员
     */
    @TableField("role")
    private Integer role;

    /**
     * chatLevel聊天等级
     */
    @TableField("chat_level")
    private Integer chatLevel;

    /**
     * pictureUrl头像地址
     */
    @TableField("picture_url")
    private String pictureUrl;

    /**
     * nickName组员昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * recordShowId消息最新展示id
     */
    @TableField("record_show_id")
    private Integer recordShowId;

    /**
     * applyId申请id
     */
    @TableField("apply_id")
    private Integer applyId;

    /**
     * lastLine最后在线时间
     */
    @TableField("last_line")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastLine;

    /**
     * lastSpeak最后发言
     */
    @TableField("last_speak")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastSpeak;

}
