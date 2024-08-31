package com.aladdin.mis.business.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.business.service.BizPostCollectService;
import com.aladdin.mis.business.entity.BizPostCollect;
import com.aladdin.mis.business.vo.BizPostCollectVo;
import com.aladdin.mis.business.qo.BizPostCollectQo;
import com.aladdin.mis.dao.business.BizPostCollectDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * BizPostCollectService
 * @author cles
 * @date 2024-08-31 21:53:08
*/
@Service
public class BizPostCollectServiceImpl extends GlobalServiceImpl<BizPostCollect> implements BizPostCollectService{

    @Autowired
    private BizPostCollectDao bizPostCollectDao;

}

