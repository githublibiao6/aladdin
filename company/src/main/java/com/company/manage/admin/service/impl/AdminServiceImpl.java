package com.company.manage.admin.service.impl;

import com.company.manage.admin.bean.Admin;
import com.company.manage.admin.dao.AdminDao;
import com.company.manage.admin.service.AdminService;
import com.company.system.common.bean.QueryCondition;
import com.company.system.common.util.MD5Util;
import com.company.system.core.service.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * admin service
 * @author lb
 * @date 2018年6月5日 下午8:55:47
 */
@Service
public class AdminServiceImpl extends GlobalService implements AdminService {

    @Autowired
    AdminDao dao;
    /**
     * 根据用户名和密码获得 admin
     * @param admin
     * @return
     */
    public boolean verification(Admin admin) {
        admin.setLoginPassword(MD5Util.MD5(admin.getLoginPassword()));
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
    public Admin getByname(String username,String pass) {
        return dao.getByname(username,pass);
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
        admin.setCreateTime(new Date());
        admin.setCreateUser(getId());
        admin.setCreateDept(getDeptId());
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
        admin.setModifyTime(new Date());
        admin.setModifyUser(getId());
        admin.setModifyDept(getDeptId());
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
