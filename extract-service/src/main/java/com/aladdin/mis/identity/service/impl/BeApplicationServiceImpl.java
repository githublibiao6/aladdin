package com.aladdin.mis.identity.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.identity.BeApplicationDao;
import com.aladdin.mis.identity.entity.BeApplication;
import com.aladdin.mis.identity.service.BeApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BeApplicationService
 * @author cles
 * @date 2024-08-21 03:21:11
*/
@Service
public class BeApplicationServiceImpl extends GlobalServiceImpl<BeApplication> implements BeApplicationService{

    @Autowired
    private BeApplicationDao beApplicationDao;

}

