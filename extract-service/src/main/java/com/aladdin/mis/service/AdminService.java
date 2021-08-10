package com.aladdin.mis.service;

import com.aladdin.mis.manager.bean.Admin;

import java.util.List;
/**
* @Description: 管理员service接口
* @Author: cles
* @Date: 2020/4/28 23:13
*/
public interface AdminService {
    List<Admin> list();
    List<Admin> pagelist();
    boolean add(Admin menu);
    boolean update(Admin menu);
    boolean remove(String id);
    Admin findById(int id);
}
