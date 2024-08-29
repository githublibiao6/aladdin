package com.aladdin.mis.chat.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.chat.service.ChatUserFriendService;
import com.aladdin.mis.chat.entity.ChatUserFriend;
import com.aladdin.mis.chat.vo.ChatUserFriendVo;
import com.aladdin.mis.chat.qo.ChatUserFriendQo;
import com.aladdin.mis.dao.chat.ChatUserFriendDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * ChatUserFriendService
 * @author cles
 * @date 2024-08-30 00:20:11
*/
@Service
public class ChatUserFriendServiceImpl extends GlobalServiceImpl<ChatUserFriend> implements ChatUserFriendService{

    @Autowired
    private ChatUserFriendDao chatUserFriendDao;

}

