package com.aladdin.mis.identity.service.impl;

import com.aladdin.mis.base.service.impl.GlobalServiceImpl;
import com.aladdin.mis.dao.manager.BeUserMenuDao;
import com.aladdin.mis.identity.entity.AdminRole;
import com.aladdin.mis.manager.entity.BeUserMenu;
import com.aladdin.mis.identity.qo.BeUserMenuQo;
import com.aladdin.mis.identity.service.AdminRoleService;
import com.aladdin.mis.identity.service.BeUserMenuService;
import com.aladdin.mis.identity.service.RoleMenuService;
import com.aladdin.mis.identity.vo.BeUserMenuVo;
import com.aladdin.mis.identity.vo.RoleMenuVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * BeUserMenuService
 * @author cles
 * @date 2022-03-01T22:38:09.336
*/
@Service
public class BeUserMenuServiceImpl extends GlobalServiceImpl<BeUserMenu> implements BeUserMenuService {

    @Autowired
    private BeUserMenuDao beUserMenuDao;

    @Autowired
    private AdminRoleService adminRoleService;

    @Autowired
    private RoleMenuService roleMenuService;

    /**
     * 分页查询
     * @param qo
     * @return
     */
    @Override
    public PageInfo<BeUserMenuVo> paginate(BeUserMenuQo qo){
       PageHelper.offsetPage(qo.getPage(), qo.getLimit());
       List<BeUserMenuVo> list = beUserMenuDao.list(qo);
       return new PageInfo<>(list);
    }

    /**
     * 查询详情
     * @param qo
     * @return
     */
    @Override
    public BeUserMenu detail(BeUserMenu qo){
       return detailQuery(qo.getId());
}
    @Override
    public boolean remove(BeUserMenu entity) {
       return delete(entity);
    }

    @Override
    public boolean update(BeUserMenu entity) {
       return updateSelective(entity);
    }

    @Override
    public BeUserMenu save(BeUserMenu entity) {
       return insertSelective(entity);
    }

    @Override
    public List<BeUserMenuVo> queryMenuByUserId(Integer userId) {
        BeUserMenuQo qo = new BeUserMenuQo();
        qo.setUserId(userId);
        List<BeUserMenuVo> result = new ArrayList<>();
        // 用户单独配置的权限
        List<BeUserMenuVo> data = beUserMenuDao.list(qo);

        List<RoleMenuVo> roleMenus = getUserRoleMenu(userId);

        Set<Integer> menuSet = new HashSet<>();
        // 先加入用户角色的权限，且编辑不可修改
        roleMenus.forEach(t->{
            BeUserMenuVo vo = new BeUserMenuVo();
            vo.setDisabled(true);
            vo.setRoleId(t.getRoleId());
            vo.setMenuPermissions(t.getMenuPermissions());
            vo.setRoleId(t.getRoleId());
            vo.setId(t.getId());
            vo.setMenuType(t.getMenuType());
            vo.setMenuId(t.getMenuId());
            vo.setRoleCode(t.getRoleCode());
            menuSet.add(t.getMenuId());
            result.add(vo);
        });
        // 再加入可修改的单人权限（去除角色的权限）
        data.forEach(t->{
            // 去除角色的权限
            if(!menuSet.contains(t.getMenuId())){
                t.setDisabled(false);
                result.add(t);
            }
        });
        return result;
    }

    @Override
    public void saveUserMenu(Integer userId, String menus) {

        // 先删除用户原有的权限
        beUserMenuDao.removeByUserId(userId);
        if(menus == null || menus.isEmpty()){
            return;
        }
        String[] array = menus.split(",");

        // 权限集合
        Set<Integer> menuSet = new HashSet<>();
        for (String s : array){
            menuSet.add(Integer.parseInt(s));
        }
        // 获取用户角色所有用的权限
        List<RoleMenuVo> roleMenus =  getUserRoleMenu(userId);

        // 去除角色拥有的权限
        roleMenus.forEach(t->{
            menuSet.remove(t.getMenuId());
        });

        // 剩下的权限就是用户独有的权限
        // 保存
        if(!menuSet.isEmpty()){
            menuSet.forEach(t->{
                BeUserMenu userMenu = new BeUserMenu();
                userMenu.setMenuId(t);
                userMenu.setUserId(userId);
                insert(userMenu);
            });
        }
    }

    /**
     * 获取用户拥有的角色 拥有的权限
     * @return
     */
    private List<RoleMenuVo> getUserRoleMenu(Integer userId){
        List<Integer> roles = new ArrayList<>();
        List<AdminRole> list = adminRoleService.getRoleByAdmin(userId);
        list.forEach(t->{
            roles.add(t.getRoleId());
        });
        List<RoleMenuVo> roleMenus =  roleMenuService.findByRoleIds(roles);
        return roleMenus;
    }

}

