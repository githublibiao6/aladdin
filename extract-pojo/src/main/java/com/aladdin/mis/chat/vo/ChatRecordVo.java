package com.aladdin.mis.chat.vo;

import com.aladdin.mis.chat.entity.ChatRecord;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 聊天会话应用层实体 
 * @author cles
 * @date 2024-07-09 00:35:53
*/
@Data
public class ChatRecordVo extends ChatRecord {

}
