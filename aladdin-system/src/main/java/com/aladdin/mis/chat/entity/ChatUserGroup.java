package com.aladdin.mis.chat.entity;

import com.aladdin.common.db.annotation.Table;
import com.aladdin.common.db.annotation.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 用户-群列："
 * @author cles
 * @date 2025-02-20 23:27:18
*/
@Table("chat_user_group")
@Data
public class ChatUserGroup extends GlobalModel {

    /**
     * groupId群主："
     */
    @TableField("group_id")
    private Integer groupId;

    /**
     * userId用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * joinTime加好友时："
     */
    @TableField("join_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime joinTime;

    /**
     * chatLevel聊天等级
     */
    @TableField("chat_level")
    private Integer chatLevel;

    /**
     * nickName本群昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * interest是否特别关注
     */
    @TableField("interest")
    private Integer interest;

    /**
     * top是否置顶
     */
    @TableField("top")
    private Integer top;

    /**
     * notDisturb是否免打："
     */
    @TableField("not_disturb")
    private Integer notDisturb;

    /**
     * groupName群聊备注
     */
    @TableField("group_name")
    private String groupName;

}
