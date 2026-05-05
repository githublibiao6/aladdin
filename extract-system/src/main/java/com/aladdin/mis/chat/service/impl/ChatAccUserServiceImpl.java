package com.aladdin.mis.chat.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.chat.service.ChatAccUserService;
import com.aladdin.mis.chat.entity.ChatAccUser;
import com.aladdin.mis.chat.vo.ChatAccUserVo;
import com.aladdin.mis.chat.qo.ChatAccUserQo;
import com.aladdin.mis.dao.chat.ChatAccUserDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * ChatAccUserService
 * @author cles
 * @date 2024-09-02 00:11:21
*/
@Service
public class ChatAccUserServiceImpl extends GlobalServiceImpl<ChatAccUser> implements ChatAccUserService{

    @Autowired
    private ChatAccUserDao chatAccUserDao;

}

