package com.aladdin.mis.identity.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.identity.BeAdminApplicationDao;
import com.aladdin.mis.identity.entity.BeAdminApplication;
import com.aladdin.mis.identity.service.BeAdminApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BeAdminApplicationService
 * @author cles
 * @date 2024-08-21 03:38:11
*/
@Service
public class BeAdminApplicationServiceImpl extends GlobalServiceImpl<BeAdminApplication> implements BeAdminApplicationService{

    @Autowired
    private BeAdminApplicationDao beAdminApplicationDao;

}

