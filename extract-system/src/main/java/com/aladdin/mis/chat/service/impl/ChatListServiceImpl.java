package com.aladdin.mis.chat.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.chat.service.ChatListService;
import com.aladdin.mis.chat.entity.ChatList;
import com.aladdin.mis.chat.vo.ChatListVo;
import com.aladdin.mis.chat.qo.ChatListQo;
import com.aladdin.mis.dao.chat.ChatListDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * ChatListService
 * @author cles
 * @date 2024-08-30 00:19:46
*/
@Service
public class ChatListServiceImpl extends GlobalServiceImpl<ChatList> implements ChatListService{

    @Autowired
    private ChatListDao chatListDao;

}

