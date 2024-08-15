package com.aladdin.mis.chat.controller;

import com.aladdin.mis.chat.entity.ChatRecord;
import com.aladdin.mis.chat.service.ChatRecordService;
import com.aladdin.mis.base.controller.GlobalController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 聊天会话 ChatRecordService---
 * @author cles
 * @date 2024-07-09 00:35:53
*/
@RequestMapping("/chatRecord")
@Controller
public class ChatRecordController  extends GlobalController<ChatRecord, ChatRecordService> {

}
