package com.aladdin.mis.chat.controller;

import com.aladdin.mis.chat.entity.ChatGroupSetting;
import com.aladdin.mis.chat.service.ChatGroupSettingService;
import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.chat.qo.ChatGroupSettingQo;
import com.aladdin.mis.chat.vo.ChatGroupSettingVo;
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
 * 聊天组群-设置信息 ChatGroupSettingService--- 
 * @author cles
 * @date 2024-08-30 00:21:21
*/
@RequestMapping("/chatGroupSetting")
@Controller
public class ChatGroupSettingController  extends GlobalController<ChatGroupSetting, ChatGroupSettingService> {

}
