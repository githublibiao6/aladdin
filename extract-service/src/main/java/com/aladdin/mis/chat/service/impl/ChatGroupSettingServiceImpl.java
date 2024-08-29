package com.aladdin.mis.chat.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.chat.service.ChatGroupSettingService;
import com.aladdin.mis.chat.entity.ChatGroupSetting;
import com.aladdin.mis.chat.vo.ChatGroupSettingVo;
import com.aladdin.mis.chat.qo.ChatGroupSettingQo;
import com.aladdin.mis.dao.chat.ChatGroupSettingDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * ChatGroupSettingService
 * @author cles
 * @date 2024-08-30 00:21:21
*/
@Service
public class ChatGroupSettingServiceImpl extends GlobalServiceImpl<ChatGroupSetting> implements ChatGroupSettingService{

    @Autowired
    private ChatGroupSettingDao chatGroupSettingDao;

}

