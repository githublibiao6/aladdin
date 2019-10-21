package com.company.manage.menu.dao;

import java.util.List;

import com.company.manage.menu.mode.Menu;

/**
 * 菜单dao
* @Description 
* @MethodName  RoleDao
* @author lb
* @date 2018年8月20日 下午11:14:28
*
 */
public interface MenuDao {

    List<Menu> list();

    List<Menu> pageList();

    int  add(Menu menu);

    int  update(Menu menu);

    Menu  findById(String  id);

    int  remove(String  id);

}
