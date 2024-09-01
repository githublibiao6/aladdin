package com.aladdin.mis.chat.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.chat.service.ChatAccUserApplyService;
import com.aladdin.mis.chat.entity.ChatAccUserApply;
import com.aladdin.mis.chat.vo.ChatAccUserApplyVo;
import com.aladdin.mis.chat.qo.ChatAccUserApplyQo;
import com.aladdin.mis.dao.chat.ChatAccUserApplyDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * ChatAccUserApplyService
 * @author cles
 * @date 2024-09-02 00:11:31
*/
@Service
public class ChatAccUserApplyServiceImpl extends GlobalServiceImpl<ChatAccUserApply> implements ChatAccUserApplyService{

    @Autowired
    private ChatAccUserApplyDao chatAccUserApplyDao;

}

