package com.aladdin.mis.identity.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.identity.service.UserScoreService;
import com.aladdin.mis.identity.entity.UserScore;
import com.aladdin.mis.identity.vo.UserScoreVo;
import com.aladdin.mis.identity.qo.UserScoreQo;
import com.aladdin.mis.dao.identity.UserScoreDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * UserScoreService
 * @author cles
 * @date 2024-09-01 23:28:33
*/
@Service
public class UserScoreServiceImpl extends GlobalServiceImpl<UserScore> implements UserScoreService{

    @Autowired
    private UserScoreDao userScoreDao;

}

