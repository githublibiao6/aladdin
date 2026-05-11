package com.aladdin.mis.identity.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.identity.UserPropertyDao;
import com.aladdin.mis.identity.entity.UserProperty;
import com.aladdin.mis.identity.service.UserPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserPropertyService
 * @author cles
 * @date 2024-09-01 23:28:25
*/
@Service
public class UserPropertyServiceImpl extends GlobalServiceImpl<UserProperty> implements UserPropertyService{

    @Autowired
    private UserPropertyDao userPropertyDao;

}

