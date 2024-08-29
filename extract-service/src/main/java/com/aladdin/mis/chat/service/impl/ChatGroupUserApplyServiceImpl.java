package com.aladdin.mis.chat.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.chat.service.ChatGroupUserApplyService;
import com.aladdin.mis.chat.entity.ChatGroupUserApply;
import com.aladdin.mis.chat.vo.ChatGroupUserApplyVo;
import com.aladdin.mis.chat.qo.ChatGroupUserApplyQo;
import com.aladdin.mis.dao.chat.ChatGroupUserApplyDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * ChatGroupUserApplyService
 * @author cles
 * @date 2024-08-30 00:19:39
*/
@Service
public class ChatGroupUserApplyServiceImpl extends GlobalServiceImpl<ChatGroupUserApply> implements ChatGroupUserApplyService{

    @Autowired
    private ChatGroupUserApplyDao chatGroupUserApplyDao;

}

