package com.aladdin.mis.service.impl;

import com.aladdin.mis.dao.manager.UserDao;
import com.aladdin.mis.manager.bean.User;
import com.aladdin.mis.pagehelper.entity.PageEntity;
import com.aladdin.mis.service.UserService;
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
//        Integer id = m.save();
//        return id != null;
        return false;
    }

    @Override
    public boolean update(User m) {
//        return m.update();
        return false;
    }

    @Override
    public boolean remove(Integer id) {
        User mode = new User();
        mode.setId(id);
//        return mode.delete();
        return false;
    }
}
