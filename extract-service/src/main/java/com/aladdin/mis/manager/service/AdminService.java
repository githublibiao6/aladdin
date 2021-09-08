package com.aladdin.mis.manager.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.manager.bean.Admin;
import com.aladdin.mis.manager.qo.DeptQo;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
* @Description: 管理员service接口
* @Author: cles
* @Date: 2020/4/28 23:13
*/
public interface AdminService  extends GlobalService<Admin> {
    List<Admin> list();
    PageInfo<Admin> pagelist(DeptQo qo);
    boolean add(Admin menu);
    boolean update(Admin menu);
    boolean remove(Integer id);
    Admin findById(int id);
}
