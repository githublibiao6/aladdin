package com.aladdin.mis.business.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.business.service.BizMemoRemindService;
import com.aladdin.mis.business.entity.BizMemoRemind;
import com.aladdin.mis.business.vo.BizMemoRemindVo;
import com.aladdin.mis.business.qo.BizMemoRemindQo;
import com.aladdin.mis.dao.business.BizMemoRemindDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * BizMemoRemindService
 * @author cles
 * @date 2024-09-01 22:26:11
*/
@Service
public class BizMemoRemindServiceImpl extends GlobalServiceImpl<BizMemoRemind> implements BizMemoRemindService{

    @Autowired
    private BizMemoRemindDao bizMemoRemindDao;

}

