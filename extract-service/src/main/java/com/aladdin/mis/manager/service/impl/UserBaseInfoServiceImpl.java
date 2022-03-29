package com.aladdin.mis.manager.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.manager.UserBaseInfoDao;
import com.aladdin.mis.manager.bean.UserBaseInfo;
import com.aladdin.mis.manager.qo.UserQo;
import com.aladdin.mis.manager.service.UserBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 菜单service
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
    public List<UserBaseInfo> list(String name) {
        UserQo qo = new UserQo();
        qo.setName(name);
        return dao.listUser(qo);
    }

    @Override
    public boolean add(UserBaseInfo m) {
        return insertSelective(m);
    }

    @Override
    public boolean update(UserBaseInfo m) {
        return updateSelective(m);
    }

    @Override
    public boolean remove(Integer id) {
        return  deleteById(id);
    }
}
