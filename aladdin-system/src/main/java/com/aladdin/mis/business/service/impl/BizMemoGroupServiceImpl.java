package com.aladdin.mis.business.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.business.service.BizMemoGroupService;
import com.aladdin.mis.business.entity.BizMemoGroup;
import com.aladdin.mis.business.vo.BizMemoGroupVo;
import com.aladdin.mis.business.qo.BizMemoGroupQo;
import com.aladdin.mis.dao.business.BizMemoGroupDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * BizMemoGroupService
 * @author cles
 * @date 2024-09-01 22:25:36
*/
@Service
public class BizMemoGroupServiceImpl extends GlobalServiceImpl<BizMemoGroup> implements BizMemoGroupService{

    @Autowired
    private BizMemoGroupDao bizMemoGroupDao;

}

