package com.aladdin.mis.chat.qo;

import com.aladdin.mis.chat.entity.ChatRecord;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 聊天会话查询实体 
 * @author cles
 * @date 2024-07-09 00:35:53
*/
@Data
public class ChatRecordQo extends ChatRecord {

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
