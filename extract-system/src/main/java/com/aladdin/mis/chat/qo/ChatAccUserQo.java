package com.aladdin.mis.chat.qo;

import com.aladdin.mis.chat.entity.ChatAccUser;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 陪聊员查询实体 
 * @author cles
 * @date 2024-09-02 00:11:21
*/
@Data
public class ChatAccUserQo extends ChatAccUser {

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
