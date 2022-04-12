package com.aladdin.mis.manager.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.manager.UserBaseInfoDao;
import com.aladdin.mis.manager.bean.UserBaseInfo;
import com.aladdin.mis.manager.service.UserBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 用户基础信息service
* @Description
* @MethodName  AdminService
* @author lb
* @date 2018年8月20日 下午11:12:29
*
 */
@Service
public class UserBaseInfoServiceImpl extends GlobalServiceImpl<UserBaseInfo> implements UserBaseInfoService {

    @Autowired
    private UserBaseInfoDao dao;

    @Override
    public void init(Integer id) {
        UserBaseInfo data = detailQuery(id);
        if(data == null){
            UserBaseInfo baseInfo = new UserBaseInfo();
            baseInfo.setId(id);
            baseInfo.setUserId(id);
            insert(baseInfo);
        }

    }
}
