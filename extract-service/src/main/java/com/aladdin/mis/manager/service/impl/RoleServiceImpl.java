package com.aladdin.mis.manager.service.impl;

import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.manager.RoleDao;
import com.aladdin.mis.manager.bean.Role;
import com.aladdin.mis.manager.bean.RoleMenu;
import com.aladdin.mis.manager.service.RoleMenuService;
import com.aladdin.mis.manager.service.RoleService;
import com.aladdin.mis.pagehelper.entity.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 菜单service
* @Description
* @MethodName  AdminService
* @author lb
* @date 2018年8月20日 下午11:12:29
*
 */
public class RoleServiceImpl extends GlobalServiceImpl<Role> implements RoleService {

    @Autowired
    private RoleDao dao;

    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    public PageEntity page(PageEntity entity) {
        List<Role> page = dao.list();
        return null;
    }

    /**
     * 获取全部角色
    * @Description
    * @MethodName listMenu
    * @return List<Role>
    * @author lb
    * @date 2018年8月21日 下午9:55:31
    *
     */
    @Override
    public List<Role> list() {
        return dao.list();
    }

    @Override
    public  List<RoleMenu> findByRoleId(Integer roleId) {
        return roleMenuService.findByRoleId(roleId);
    }


    @Override
    public boolean add(Role role, String menus) {
        role = insertSelective(role);
        System.err.println(role);
        Integer id = 0;
        if(role.getId() != null){
            saveRoleMenu(id, menus);
        }
        return false;
    }

    @Override
    public Set<String> getRolesByUserId(Integer id) {
        Set<String> set = new HashSet<>();
        List<Role> list  = dao.queryRolesByUserId(id);
        // todo 根据admin查询角色
        list.forEach(t->{
            set.add(t.getCode());
        });
        return set;
    }

    @Override
    public boolean remove(Integer id){
        deleteById(id);
        return  true;
    }
    @Override
    public boolean update(Role role, String menus){
        if(updateSelective(role)){
            saveRoleMenu(role.getId(), menus);
        }else {
            return false;
        }
        return true;
    }

    @Override
    public Role findById(Integer menuId){
        return dao.findById(menuId);
    }

    /**
     * 功能描述：
     *  < 角色id，和菜单组 建立关联>
     * @Description: saveRoleMenu
     * @Author: cles
     * @Date: 2020/7/8 22:47
     * @param roleId 参数1
     * @param menus 参数2
     * @return: void
     * @version: 1.0.0
     */
    private void saveRoleMenu(Integer roleId, String menus){
        roleMenuService.removeByRoleId(roleId);
        String[] arr = menus.split(",");
        for (String menu : arr) {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setMenuId(Integer.parseInt(menu));
            roleMenu.setRoleId(roleId);
            insertSelective(roleMenu);
        }
    }
}
