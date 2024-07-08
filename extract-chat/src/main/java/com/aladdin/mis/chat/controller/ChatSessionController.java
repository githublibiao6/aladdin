package com.aladdin.mis.chat.controller;

import com.aladdin.mis.chat.entity.ChatSession;
import com.aladdin.mis.chat.service.ChatSessionService;
import com.aladdin.mis.system.controller.GlobalController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 聊天记录 ChatSessionService---
 * @author cles
 * @date 2024-07-09 00:35:45
*/
@RequestMapping("/chatSession")
@Controller
public class ChatSessionController  extends GlobalController<ChatSession, ChatSessionService> {

}
