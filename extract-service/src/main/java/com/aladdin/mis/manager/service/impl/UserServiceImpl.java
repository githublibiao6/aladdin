package com.aladdin.mis.manager.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.manager.UserDao;
import com.aladdin.mis.manager.bean.User;
import com.aladdin.mis.manager.qo.UserQo;
import com.aladdin.mis.manager.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
public class UserServiceImpl extends GlobalServiceImpl<User> implements UserService {

    @Autowired
    UserDao dao;


    @Override
    public PageInfo<User> page(UserQo qo) {
        PageHelper.offsetPage(qo.getPage(), qo.getLimit());
        List<User> list = dao.listUser(qo);
        return new PageInfo<>(list);
    }

    @Override
    public List<User> list(String name) {
        UserQo qo = new UserQo();
        qo.setName(name);
        return dao.listUser(qo);
    }

    @Override
    public boolean add(User m) {
        insertSelective(m);
        return false;
    }

    @Override
    public boolean update(User m) {
        updateSelective(m);
        return false;
    }

    @Override
    public boolean remove(Integer id) {
        deleteById(id);
        return false;
    }
}
