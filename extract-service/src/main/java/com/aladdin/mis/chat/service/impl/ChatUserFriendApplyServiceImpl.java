package com.aladdin.mis.chat.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.chat.service.ChatUserFriendApplyService;
import com.aladdin.mis.chat.entity.ChatUserFriendApply;
import com.aladdin.mis.chat.vo.ChatUserFriendApplyVo;
import com.aladdin.mis.chat.qo.ChatUserFriendApplyQo;
import com.aladdin.mis.dao.chat.ChatUserFriendApplyDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * ChatUserFriendApplyService
 * @author cles
 * @date 2024-08-30 00:20:18
*/
@Service
public class ChatUserFriendApplyServiceImpl extends GlobalServiceImpl<ChatUserFriendApply> implements ChatUserFriendApplyService{

    @Autowired
    private ChatUserFriendApplyDao chatUserFriendApplyDao;

}

