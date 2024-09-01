package com.aladdin.mis.chat.controller;

import com.aladdin.mis.chat.entity.ChatAccUser;
import com.aladdin.mis.chat.service.ChatAccUserService;
import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.chat.qo.ChatAccUserQo;
import com.aladdin.mis.chat.vo.ChatAccUserVo;
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
 * 陪聊员 ChatAccUserService--- 
 * @author cles
 * @date 2024-09-02 00:11:21
*/
@RequestMapping("/chatAccUser")
@Controller
public class ChatAccUserController  extends GlobalController<ChatAccUser, ChatAccUserService> {

}
