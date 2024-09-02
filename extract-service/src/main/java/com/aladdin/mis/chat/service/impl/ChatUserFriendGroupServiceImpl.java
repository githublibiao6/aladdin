package com.aladdin.mis.chat.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.chat.service.ChatUserFriendGroupService;
import com.aladdin.mis.chat.entity.ChatUserFriendGroup;
import com.aladdin.mis.chat.vo.ChatUserFriendGroupVo;
import com.aladdin.mis.chat.qo.ChatUserFriendGroupQo;
import com.aladdin.mis.dao.chat.ChatUserFriendGroupDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * ChatUserFriendGroupService
 * @author cles
 * @date 2024-09-02 22:01:41
*/
@Service
public class ChatUserFriendGroupServiceImpl extends GlobalServiceImpl<ChatUserFriendGroup> implements ChatUserFriendGroupService{

    @Autowired
    private ChatUserFriendGroupDao chatUserFriendGroupDao;

}

