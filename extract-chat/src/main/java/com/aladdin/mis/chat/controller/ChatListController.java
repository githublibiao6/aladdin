package com.aladdin.mis.chat.controller;

import com.aladdin.mis.base.controller.GlobalController;
import com.aladdin.mis.chat.entity.ChatList;
import com.aladdin.mis.chat.service.ChatListService;
import com.aladdin.mis.shiro.OmClient;
import com.aladdin.common.security.entity.OmUser;
import com.alibaba.fastjson2.JSONObject;
import com.aladdin.common.security.entity.OmUser;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 聊天列表 ChatListService---
 * @author cles
 * @date 2024-08-30 00:19:46
*/
@RequestMapping("/chatList")
@Controller
public class ChatListController  extends GlobalController<ChatList, ChatListService> {

    /**
     * 获取信息列表
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public JSONObject list() {
        OmUser user = OmClient.getCurrentUser();
        JSONObject o = new JSONObject();
        o.put("success", true);
        o.put("code", 20000);
        o.put("data", user);
        return o;
    }

}
