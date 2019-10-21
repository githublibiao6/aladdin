package com.company.manage.admin.service;

import com.company.manage.admin.bean.Admin;
import com.company.manage.menu.mode.Menu;

import java.util.List;

public interface AdminService {
    List<Admin> list();
    List<Admin> pagelist();
    boolean add(Admin menu);
    boolean update(Admin menu);
    boolean remove(String id);
    Admin findById(String id);
}
