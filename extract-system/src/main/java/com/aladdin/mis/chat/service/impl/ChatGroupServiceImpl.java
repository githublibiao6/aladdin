package com.aladdin.mis.chat.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.chat.service.ChatGroupService;
import com.aladdin.mis.chat.entity.ChatGroup;
import com.aladdin.mis.chat.vo.ChatGroupVo;
import com.aladdin.mis.chat.qo.ChatGroupQo;
import com.aladdin.mis.dao.chat.ChatGroupDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * ChatGroupService
 * @author cles
 * @date 2024-08-30 00:19:09
*/
@Service
public class ChatGroupServiceImpl extends GlobalServiceImpl<ChatGroup> implements ChatGroupService{

    @Autowired
    private ChatGroupDao chatGroupDao;

}

