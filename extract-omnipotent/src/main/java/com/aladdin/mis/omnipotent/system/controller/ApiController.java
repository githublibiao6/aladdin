package com.aladdin.mis.omnipotent.system.controller;

import com.aladdin.mis.chat.entity.ChatUserFriendGroup;
import com.aladdin.mis.chat.service.ChatUserFriendGroupService;
import com.aladdin.mis.common.system.entity.Result;
import com.aladdin.mis.omnipotent.system.threadpool.service.impl.AsyncServiceImpl;
import com.aladdin.mis.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @Description:  api测试
* @Author: cles
* @Date: 2020/4/17 23:46
*/
@Controller
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private AsyncServiceImpl asyncService;

    @Autowired
    private ChatUserFriendGroupService groupService;

    /** 测试异步执行
     * @Author cles
     * @Description
     * @Date 23:14 2019/7/10
     * @return java.lang.String
     **/
    @RequestMapping("/test")
    @ResponseBody
    public Result test() {
        Result result = new Result();
        result.setSuccess(true);
        ChatUserFriendGroup group = new ChatUserFriendGroup();
        group.setGroupName("&&&&&");
        group.setUserId(UserUtil.getCurrentUser().getUserId());
        groupService.insert(group);
        return result;
    }

}
