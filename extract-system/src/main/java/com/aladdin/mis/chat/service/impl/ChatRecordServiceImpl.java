package com.aladdin.mis.chat.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.chat.service.ChatRecordService;
import com.aladdin.mis.chat.entity.ChatRecord;
import com.aladdin.mis.chat.vo.ChatRecordVo;
import com.aladdin.mis.chat.qo.ChatRecordQo;
import com.aladdin.mis.dao.chat.ChatRecordDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * ChatRecordService
 * @author cles
 * @date 2024-07-09 00:35:53
*/
@Service
public class ChatRecordServiceImpl extends GlobalServiceImpl<ChatRecord> implements ChatRecordService{

    @Autowired
    private ChatRecordDao chatRecordDao;

}

