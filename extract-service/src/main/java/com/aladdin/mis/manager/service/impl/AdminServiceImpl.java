package com.aladdin.mis.manager.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.manager.AdminDao;
import com.aladdin.mis.manager.bean.Admin;
import com.aladdin.mis.manager.qo.DeptQo;
import com.aladdin.mis.manager.service.AdminService;
import com.aladdin.mis.pagehelper.entity.QueryCondition;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * admin service
 * @author lb
 * @date 2018年6月5日 下午8:55:47
 */
@Service
public class AdminServiceImpl extends GlobalServiceImpl<Admin> implements AdminService {

    @Autowired
    AdminDao dao;
    /**
     * 根据用户名和密码获得 admin
     * @param admin
     * @return
     */
    public boolean verification(Admin admin) {
        admin.setLoginPassword("");
        Admin a =  dao.verification(admin);
        if(a != null){
            return true;
        }else{
            return false;
        }

    }
    /**
     * 根据用户名获得 admin
     * @param username
     * @return
     */
    public Admin getByname(String username, String pass) {
        return dao.getByName(username,pass);
    }
    @Override
    public List<Admin> list() {
        return dao.list();
    }
    @Override
    public PageInfo<Admin> pagelist(DeptQo qo) {
        PageHelper.offsetPage(qo.getPage(), qo.getLimit());
        List<Admin>  list = dao.pageList(qo);
        return new PageInfo<>(list);
    }

    @Override
    public boolean add(Admin admin) {
        boolean flag = true;

        admin.setLoginPassword(UUID.randomUUID().toString());
        int num = dao.add(admin);
        if(num > 0){
            flag = false;
        }
        return flag;
    }

    @Override
    public Admin findById(int id){
        return dao.findById(id);
    }

    @Override
    public boolean remove(Integer id){
        return deleteById(id);
    }
    @Override
    public boolean update(Admin admin){
        boolean flag = false;

//        admin.setDeleteFlag("1");
        System.out.println(admin.getId());
        int num = dao.update(admin);
        if(num > 0){
            flag = true;
        }
        return flag;
    }

    /**
     * 获得全部的 admin （导出）
     * @param queryCondition
     * @return
     */
    public List<Admin> getAll(QueryCondition queryCondition) {
        return dao.listAdmin(queryCondition);
    }

}
