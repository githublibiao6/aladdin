package com.aladdin.mis.omnipotent.manager.service.impl;

import com.aladdin.mis.omnipotent.manager.service.RoleService;
import com.aladdin.mis.omnipotent.manager.bean.RoleMenu;
import com.aladdin.mis.omnipotent.manager.dao.RoleDao;
import com.aladdin.mis.omnipotent.manager.bean.Role;
import com.aladdin.mis.omnipotent.manager.service.RoleMenuService;
import com.aladdin.mis.omnipotent.system.global.service.impl.GlobalServiceImpl;
import com.aladdin.mis.omnipotent.system.pagehelper.entity.PageEntity;
import com.aladdin.mis.omnipotent.system.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class RoleServiceImpl extends GlobalServiceImpl implements RoleService {

    @Autowired
    RoleDao dao;
    @Autowired
    RoleMenuService roleMenuService;

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
    public  List<RoleMenu> findByRoleId(String roleId) {
        return roleMenuService.findByRoleId(roleId);
    }


    @Override
    public boolean add(Role role, String menus) {
        role.setEffectiveFlag("1");
        role.setDeleteFlag("1");
        String id = role.save();
        if(StringUtil.notBlank(id)){
            saveRoleMenu(id, menus);
        }
        return !StringUtil.isBlank(id);
    }

    @Override
    public Set<String> getRolesByUserId(String id) {
        Set<String> set = new HashSet<>();
        List<Role> list  = dao.queryRolesByUserId(id);
        // todo 根据admin查询角色
        list.forEach(t->{
            set.add(t.getCode());
        });
        return set;
    }

    @Override
    public boolean remove(String id){
        Role role = new Role();
        role.setId(id);
        return role.delete();
    }
    @Override
    public boolean update(Role role, String menus){
        if(role.update()){
            saveRoleMenu(role.getId(), menus);
        }else {
            return false;
        }
        return true;
    }

    @Override
    public Role findById(String menuId){
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
    private void saveRoleMenu(String roleId, String menus){
        roleMenuService.removeByRoleId(roleId);
        String[] arr = menus.split(",");
        for (String menu : arr) {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setMenuId(menu);
            roleMenu.setRoleId(roleId);
            roleMenu.save();
        }
    }
}
