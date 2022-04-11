package com.aladdin.mis.manager.service.impl;

import com.aladdin.mis.base.qo.QueryCondition;
import com.aladdin.mis.common.system.entity.Result;
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
        return insertSelective(m);
    }

    @Override
    public boolean update(User m) {
        return updateSelective(m);
    }

    @Override
    public boolean remove(Integer id) {
        return  deleteById(id);
    }

    @Override
    public Result register(User entity) {
        User userPhone = getByCondition(QueryCondition.newInstance().addExpression("phone", entity.getPhone()));
        if(userPhone != null){
            return Result.error(50015, "用户手机号已被占用");
        }
        User userAccount = getByCondition(QueryCondition.newInstance().addExpression("account", entity.getAccount()));
        if(userAccount != null){
            return Result.error(50016, "用户名已存在");
        }
        User data = insertSelective(entity);

        return Result.success("注册成功", data);
    }
}
