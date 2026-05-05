package com.aladdin.mis.chat.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.chat.service.ChatGroupUserService;
import com.aladdin.mis.chat.entity.ChatGroupUser;
import com.aladdin.mis.chat.vo.ChatGroupUserVo;
import com.aladdin.mis.chat.qo.ChatGroupUserQo;
import com.aladdin.mis.dao.chat.ChatGroupUserDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * ChatGroupUserService
 * @author cles
 * @date 2024-08-30 00:19:29
*/
@Service
public class ChatGroupUserServiceImpl extends GlobalServiceImpl<ChatGroupUser> implements ChatGroupUserService{

    @Autowired
    private ChatGroupUserDao chatGroupUserDao;

}

