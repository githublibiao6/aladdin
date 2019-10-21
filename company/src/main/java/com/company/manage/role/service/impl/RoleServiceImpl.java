package com.company.manage.role.service.impl;

import com.company.manage.role.dao.RoleDao;
import com.company.manage.role.mode.Role;
import com.company.manage.role.service.RoleService;
import com.company.system.core.service.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * 菜单service
* @Description
* @MethodName  AdminService
* @author lb
* @date 2018年8月20日 下午11:12:29
*
 */
@Service
public class RoleServiceImpl extends GlobalService implements RoleService {

    @Autowired
    RoleDao dao;

    /**
     * 获取菜单
    * @Description
    * @MethodName listMenu
    * @return List<Role>
    * @author lb
    * @date 2018年8月21日 下午9:55:31
    *
     */
    public List<Role> list() {
        return dao.list();
    }
    public List<Role>  pagelist() {
        List<Role>  list = dao.pageList();
        return list;
    }

    public boolean add(Role menu) {
        menu.setId(UUID.randomUUID().toString());
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

    public Role findById(String menuId){
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
    public boolean update(Role menu){
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
