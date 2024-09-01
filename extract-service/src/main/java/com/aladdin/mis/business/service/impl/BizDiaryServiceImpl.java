package com.aladdin.mis.business.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.business.service.BizDiaryService;
import com.aladdin.mis.business.entity.BizDiary;
import com.aladdin.mis.business.vo.BizDiaryVo;
import com.aladdin.mis.business.qo.BizDiaryQo;
import com.aladdin.mis.dao.business.BizDiaryDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * BizDiaryService
 * @author cles
 * @date 2024-09-01 20:50:27
*/
@Service
public class BizDiaryServiceImpl extends GlobalServiceImpl<BizDiary> implements BizDiaryService{

    @Autowired
    private BizDiaryDao bizDiaryDao;

}

