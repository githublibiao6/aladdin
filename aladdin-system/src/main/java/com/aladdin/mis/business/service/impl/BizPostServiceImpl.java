package com.aladdin.mis.business.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.business.service.BizPostService;
import com.aladdin.mis.business.entity.BizPost;
import com.aladdin.mis.business.vo.BizPostVo;
import com.aladdin.mis.business.qo.BizPostQo;
import com.aladdin.mis.dao.business.BizPostDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * BizPostService
 * @author cles
 * @date 2024-08-31 21:50:30
*/
@Service
public class BizPostServiceImpl extends GlobalServiceImpl<BizPost> implements BizPostService{

    @Autowired
    private BizPostDao bizPostDao;

}

