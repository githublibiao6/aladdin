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
 * @date 2024-08-30 00:20:11
*/
@Table("chat_user_friend")
@Data
public class ChatUserFriend extends GlobalModel {

    /**
     * friendId好友主键
     */
    @TableField("friend_id")
    private Integer friendId;

    /**
     * userId用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * joinTime加好友时间
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
