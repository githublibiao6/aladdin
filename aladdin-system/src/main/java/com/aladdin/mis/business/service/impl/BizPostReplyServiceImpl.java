package com.aladdin.mis.business.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.business.service.BizPostReplyService;
import com.aladdin.mis.business.entity.BizPostReply;
import com.aladdin.mis.business.vo.BizPostReplyVo;
import com.aladdin.mis.business.qo.BizPostReplyQo;
import com.aladdin.mis.dao.business.BizPostReplyDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * BizPostReplyService
 * @author cles
 * @date 2024-08-31 21:52:48
*/
@Service
public class BizPostReplyServiceImpl extends GlobalServiceImpl<BizPostReply> implements BizPostReplyService{

    @Autowired
    private BizPostReplyDao bizPostReplyDao;

}

