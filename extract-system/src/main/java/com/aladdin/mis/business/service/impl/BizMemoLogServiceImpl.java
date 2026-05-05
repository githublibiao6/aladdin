package com.aladdin.mis.business.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.business.service.BizMemoLogService;
import com.aladdin.mis.business.entity.BizMemoLog;
import com.aladdin.mis.business.vo.BizMemoLogVo;
import com.aladdin.mis.business.qo.BizMemoLogQo;
import com.aladdin.mis.dao.business.BizMemoLogDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * BizMemoLogService
 * @author cles
 * @date 2024-09-01 22:25:53
*/
@Service
public class BizMemoLogServiceImpl extends GlobalServiceImpl<BizMemoLog> implements BizMemoLogService{

    @Autowired
    private BizMemoLogDao bizMemoLogDao;

}

