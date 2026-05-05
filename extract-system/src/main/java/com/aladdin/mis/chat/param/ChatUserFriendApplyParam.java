package com.aladdin.mis.chat.param;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 聊天记录-两人对话
 * @author cles
 * @date 2024-08-30 00:20:18
*/
@Data
public class ChatUserFriendApplyParam {

    /**
     * friendId申请朋友id
     */
    private Integer friendNumber;

    /**
     * source朋友来源
     */
    private Integer source;

    /**
     * applyMessage申请消息
     */
    private String applyMessage;
}
