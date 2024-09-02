package com.aladdin.mis.chat.controller;

import com.aladdin.mis.chat.entity.ChatUserFriendGroup;
import com.aladdin.mis.chat.service.ChatUserFriendGroupService;
import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.chat.qo.ChatUserFriendGroupQo;
import com.aladdin.mis.chat.vo.ChatUserFriendGroupVo;
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
 * 朋友分组 ChatUserFriendGroupService--- 
 * @author cles
 * @date 2024-09-02 22:01:41
*/
@RequestMapping("/chatUserFriendGroup")
@Controller
public class ChatUserFriendGroupController  extends GlobalController<ChatUserFriendGroup, ChatUserFriendGroupService> {

}
