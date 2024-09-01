package com.aladdin.mis.chat.controller;

import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.chat.entity.ChatAccUserApply;
import com.aladdin.mis.chat.service.ChatAccUserApplyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 陪聊员 ChatAccUserApplyService---
 * @author cles
 * @date 2024-09-02 00:11:31
*/
@RequestMapping("/chatAccUserApply")
@Controller
public class ChatAccUserApplyController  extends GlobalController<ChatAccUserApply, ChatAccUserApplyService> {

}
