package com.aladdin.mis.chat.vo;

import com.aladdin.mis.chat.entity.ChatList;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 聊天列表应用层实体 
 * @author cles
 * @date 2024-08-30 00:19:46
*/
@Data
public class ChatListVo extends ChatList {

}
