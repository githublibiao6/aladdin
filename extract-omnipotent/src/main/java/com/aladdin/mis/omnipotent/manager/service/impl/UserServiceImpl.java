package com.aladdin.mis.omnipotent.manager.service.impl;

import com.aladdin.mis.omnipotent.manager.bean.User;
import com.aladdin.mis.omnipotent.manager.dao.UserDao;
import com.aladdin.mis.omnipotent.manager.service.UserService;
import com.aladdin.mis.omnipotent.system.global.service.impl.GlobalServiceImpl;
import com.aladdin.mis.omnipotent.system.pagehelper.entity.PageEntity;
import com.aladdin.mis.omnipotent.system.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * 菜单service
* @Description
* @MethodName  AdminService
* @author lb
* @date 2018年8月20日 下午11:12:29
*
 */
@Service
public class UserServiceImpl extends GlobalServiceImpl implements UserService {

    @Autowired
    UserDao dao;


    @Override
    public PageEntity page(PageEntity entity) {
        List<User> page = dao.pageUser();
        return null;
    }

    @Override
    public List<User> list(String name) {
        return dao.listUser(name);
    }

    @Override
    public boolean add(User m) {
        m.setCreateTime(new Date());
        m.setCreateUser("");
        m.setDeleteFlag("1");
        String id = m.save();
        return !StringUtil.isBlank(id);
    }

    @Override
    public boolean update(User m) {
        return m.update();
    }

    @Override
    public boolean remove(String id) {
        User mode = new User();
        mode.setId(id);
        return mode.delete();
    }
}
