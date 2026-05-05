package com.aladdin.mis.chat.qo;

import com.aladdin.mis.chat.entity.ChatUserFriendApply;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 聊天记录-两人对话查询实体 
 * @author cles
 * @date 2024-08-30 00:20:18
*/
@Data
public class ChatUserFriendApplyQo extends ChatUserFriendApply {

    private Integer page;

    private Integer limit;

    /**
     * 关键字条件过滤 
     */
    private String  keyWord;
    /**
     * 排序条件 
     */
    private String  sortInfo;
}
