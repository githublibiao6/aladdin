package com.aladdin.mis.shiro.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.shiro.BeAuthUrlDao;
import com.aladdin.mis.shiro.entity.BeAuthUrl;
import com.aladdin.mis.shiro.qo.BeAuthUrlQo;
import com.aladdin.mis.shiro.service.BeAuthUrlService;
import com.aladdin.mis.shiro.vo.BeAuthUrlVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * BeAuthUrlService
 * @author cles
 * @date 2023-02-03 23:50:29
*/
@Service
public class BeAuthUrlServiceImpl extends GlobalServiceImpl<BeAuthUrl> implements BeAuthUrlService{

    @Autowired
    private BeAuthUrlDao beAuthUrlDao;

    @Override
    public List<BeAuthUrlVo> list() {
        BeAuthUrlQo qo = new BeAuthUrlQo();
        qo.setSortInfo("sort asc");
        return beAuthUrlDao.list(qo);
    }
}

