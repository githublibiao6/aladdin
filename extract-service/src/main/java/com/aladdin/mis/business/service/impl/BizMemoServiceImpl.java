package com.aladdin.mis.business.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.business.service.BizMemoService;
import com.aladdin.mis.business.entity.BizMemo;
import com.aladdin.mis.business.vo.BizMemoVo;
import com.aladdin.mis.business.qo.BizMemoQo;
import com.aladdin.mis.dao.business.BizMemoDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * BizMemoService
 * @author cles
 * @date 2024-09-01 22:25:16
*/
@Service
public class BizMemoServiceImpl extends GlobalServiceImpl<BizMemo> implements BizMemoService{

    @Autowired
    private BizMemoDao bizMemoDao;

}

