package com.aladdin.mis.chat.vo;

import com.aladdin.mis.chat.entity.ChatGroupUser;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 聊天记录-两人对话应用层实体 
 * @author cles
 * @date 2024-08-30 00:19:29
*/
@Data
public class ChatGroupUserVo extends ChatGroupUser {

}
