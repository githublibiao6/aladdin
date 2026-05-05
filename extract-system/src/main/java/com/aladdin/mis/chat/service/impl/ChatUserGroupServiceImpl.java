package com.aladdin.mis.chat.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.chat.service.ChatUserGroupService;
import com.aladdin.mis.chat.entity.ChatUserGroup;
import com.aladdin.mis.chat.vo.ChatUserGroupVo;
import com.aladdin.mis.chat.qo.ChatUserGroupQo;
import com.aladdin.mis.dao.chat.ChatUserGroupDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * ChatUserGroupService
 * @author cles
 * @date 2024-08-30 00:20:29
*/
@Service
public class ChatUserGroupServiceImpl extends GlobalServiceImpl<ChatUserGroup> implements ChatUserGroupService{

    @Autowired
    private ChatUserGroupDao chatUserGroupDao;

}

