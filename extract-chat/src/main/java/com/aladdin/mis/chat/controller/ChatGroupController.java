package com.aladdin.mis.chat.controller;

import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.chat.entity.ChatGroup;
import com.aladdin.mis.chat.service.ChatGroupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 聊天组群 ChatGroupService---
 * @author cles
 * @date 2024-08-30 00:19:09
*/
@RequestMapping("/chatGroup")
@Controller
public class ChatGroupController  extends GlobalController<ChatGroup, ChatGroupService> {

}
