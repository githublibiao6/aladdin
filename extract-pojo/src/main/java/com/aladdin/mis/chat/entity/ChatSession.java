package com.aladdin.mis.chat.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.mapper.base.GlobalModel;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 聊天记录-两人对话
 * @author cles
 * @date 2025-02-20 23:26:50
*/
@Table("chat_session")
@Data
public class ChatSession extends GlobalModel {

    /**
     * sessionName会话名称
     */
    @TableField("session_name")
    private String sessionName;

    /**
     * sessionKind会话类别
     */
    @TableField("session_kind")
    private Integer sessionKind;

    /**
     * createTime创建时间
     */
    @TableField("create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * createUser创建者
     */
    @TableField("create_user")
    private Integer createUser;

    /**
     * chatUser接受者
     */
    @TableField("chat_user")
    private Integer chatUser;

    /**
     * chatLevel聊天等级
     */
    @TableField("chat_level")
    private Integer chatLevel;

}
