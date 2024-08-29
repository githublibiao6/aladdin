package com.aladdin.mis.chat.controller;

import com.aladdin.mis.chat.entity.ChatGroupRecord;
import com.aladdin.mis.chat.service.ChatGroupRecordService;
import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.chat.qo.ChatGroupRecordQo;
import com.aladdin.mis.chat.vo.ChatGroupRecordVo;
import com.aladdin.mis.common.annotation.WebLog;
import com.aladdin.mis.common.system.entity.Result;
import com.github.pagehelper.PageInfo;
import com.aladdin.mis.base.service.GlobalService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * 聊天会话-两人对话 ChatGroupRecordService--- 
 * @author cles
 * @date 2024-08-30 00:19:17
*/
@RequestMapping("/chatGroupRecord")
@Controller
public class ChatGroupRecordController  extends GlobalController<ChatGroupRecord, ChatGroupRecordService> {

}
