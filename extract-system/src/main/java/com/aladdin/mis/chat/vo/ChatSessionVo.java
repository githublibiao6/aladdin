package com.aladdin.mis.chat.vo;

import com.aladdin.mis.chat.entity.ChatSession;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 聊天记录应用层实体 
 * @author cles
 * @date 2024-07-09 00:35:45
*/
@Data
public class ChatSessionVo extends ChatSession {

}
