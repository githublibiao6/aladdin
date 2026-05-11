package com.aladdin.mis.chat.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.chat.service.ChatGroupRecordService;
import com.aladdin.mis.chat.entity.ChatGroupRecord;
import com.aladdin.mis.chat.vo.ChatGroupRecordVo;
import com.aladdin.mis.chat.qo.ChatGroupRecordQo;
import com.aladdin.mis.dao.chat.ChatGroupRecordDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * ChatGroupRecordService
 * @author cles
 * @date 2024-08-30 00:19:17
*/
@Service
public class ChatGroupRecordServiceImpl extends GlobalServiceImpl<ChatGroupRecord> implements ChatGroupRecordService{

    @Autowired
    private ChatGroupRecordDao chatGroupRecordDao;

}

