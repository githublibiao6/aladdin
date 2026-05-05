package com.aladdin.mis.chat.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.chat.service.ChatSessionService;
import com.aladdin.mis.chat.entity.ChatSession;
import com.aladdin.mis.chat.vo.ChatSessionVo;
import com.aladdin.mis.chat.qo.ChatSessionQo;
import com.aladdin.mis.dao.chat.ChatSessionDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * ChatSessionService
 * @author cles
 * @date 2024-07-09 00:35:45
*/
@Service
public class ChatSessionServiceImpl extends GlobalServiceImpl<ChatSession> implements ChatSessionService{

    @Autowired
    private ChatSessionDao chatSessionDao;

}

