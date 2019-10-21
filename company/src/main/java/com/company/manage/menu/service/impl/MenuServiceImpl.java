package com.company.manage.menu.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.company.system.core.service.GlobalService;
import com.company.manage.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.manage.menu.dao.MenuDao;
import com.company.manage.menu.mode.Menu;


/**
 * 菜单service
* @Description
* @MethodName  AdminService
* @author lb
* @date 2018年8月20日 下午11:12:29
*
 */
@Service
public class MenuServiceImpl extends GlobalService implements MenuService {

    @Autowired
    MenuDao dao;

    /**
     * 获取菜单
    * @Description
    * @MethodName listMenu
    * @return List<Role>
    * @author lb
    * @date 2018年8月21日 下午9:55:31
    *
     */
    public List<Menu> list() {
        return dao.list();
    }
    public List<Menu>  pagelist() {
        List<Menu>  list = dao.pageList();
        return list;
    }

    public boolean add(Menu menu) {
        menu.setMenuId(UUID.randomUUID().toString());
        boolean flag = true;
        menu.setCreateTime(new Date());
        menu.setCreateUser(getId());
        menu.setCreateDept(getDeptId());
        menu.setDeleteFlag("1");
        int num = dao.add(menu);
        if(num > 1){
            flag = false;
        }
        return flag;
    }

    public Menu findById(String menuId){
        return dao.findById(menuId);
    }
    public boolean remove(String menuId){
        boolean flag = true;
        int num = dao.remove(menuId);
        if(num > 1){
            flag = false;
        }
        return flag;
    }
    public boolean update(Menu menu){
        boolean flag = true;
        menu.setModifyTime(new Date());
        menu.setModifyUser(getId());
        menu.setModifyDept(getDeptId());
        int num = dao.update(menu);
        if(num > 1){
            flag = false;
        }
        return flag;
    }
}
