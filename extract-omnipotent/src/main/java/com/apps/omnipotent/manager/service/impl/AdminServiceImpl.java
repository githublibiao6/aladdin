package com.apps.omnipotent.manager.service.impl;

import com.apps.omnipotent.manager.bean.Admin;
import com.apps.omnipotent.manager.dao.AdminDao;
import com.apps.omnipotent.system.global.service.impl.GlobalServiceImpl;
import com.apps.omnipotent.system.pagehelper.entity.QueryCondition;
import com.apps.omnipotent.system.global.service.GlobalService;
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
public class AdminServiceImpl extends GlobalServiceImpl {

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
    public List<Admin> list() {
        return dao.list();
    }
    public List<Admin>  pagelist() {
        List<Admin>  list = dao.pageList();
        return list;
    }

    public boolean add(Admin admin) {
        admin.setId(UUID.randomUUID().toString());
        boolean flag = true;

        admin.setLoginPassword(UUID.randomUUID().toString());
        int num = dao.add(admin);
        if(num > 0){
            flag = false;
        }
        return flag;
    }

    public Admin findById(String id){
        return dao.findById(id);
    }
    public boolean remove(String menuId){
        boolean flag = true;
        int num = dao.remove(menuId);
        if(num > 1){
            flag = false;
        }
        return flag;
    }
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
