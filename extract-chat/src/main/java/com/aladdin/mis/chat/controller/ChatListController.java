package com.aladdin.mis.chat.controller;

import com.aladdin.mis.chat.entity.ChatList;
import com.aladdin.mis.chat.service.ChatListService;
import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.chat.qo.ChatListQo;
import com.aladdin.mis.chat.vo.ChatListVo;
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
 * 聊天列表 ChatListService--- 
 * @author cles
 * @date 2024-08-30 00:19:46
*/
@RequestMapping("/chatList")
@Controller
public class ChatListController  extends GlobalController<ChatList, ChatListService> {

}
