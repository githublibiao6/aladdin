package com.aladdin.mis.chat.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 朋友关联
 * @author cles
 * @date 2025-02-20 23:26:57
*/
@Table("chat_user_friend")
@Data
public class ChatUserFriend extends GlobalModel {

    /**
     * userId用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * groupId朋友分组
     */
    @TableField("group_id")
    private Integer groupId;

    /**
     * friendId好友主键
     */
    @TableField("friend_id")
    private Integer friendId;

    /**
     * joinTime加好友时间
     */
    @TableField("join_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime joinTime;

    /**
     * chatId两人聊天id
     */
    @TableField("chat_id")
    private Integer chatId;

    /**
     * chatListId聊天列表id
     */
    @TableField("chat_list_id")
    private Integer chatListId;

    /**
     * chatLevel聊天等级
     */
    @TableField("chat_level")
    private Integer chatLevel;

    /**
     * nickName好友备注
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * interest是否特别关注
     */
    @TableField("interest")
    private Integer interest;

}
