package com.aladdin.mis.business.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.business.service.BizPostThumbService;
import com.aladdin.mis.business.entity.BizPostThumb;
import com.aladdin.mis.business.vo.BizPostThumbVo;
import com.aladdin.mis.business.qo.BizPostThumbQo;
import com.aladdin.mis.dao.business.BizPostThumbDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * BizPostThumbService
 * @author cles
 * @date 2024-08-31 21:53:31
*/
@Service
public class BizPostThumbServiceImpl extends GlobalServiceImpl<BizPostThumb> implements BizPostThumbService{

    @Autowired
    private BizPostThumbDao bizPostThumbDao;

}

