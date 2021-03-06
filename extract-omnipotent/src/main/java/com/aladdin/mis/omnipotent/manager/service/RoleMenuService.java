package com.aladdin.mis.omnipotent.manager.service;

import com.aladdin.mis.omnipotent.manager.bean.RoleMenu;

import java.util.List;

/**
* @Description: 角色service
* @Author: cles
* @Date: 2020/4/15 23:48
*/
public interface RoleMenuService {

    /**
     * 功能描述：
     *  < 删除 >
     * @Description: removeByRoleId
     * @Author: cles
     * @Date: 2020/7/6 0:07
     * @param roleId 参数1
     * @return: boolean
     * @version: 1.0.0
     */
    boolean removeByRoleId(String roleId);

    /**
     * 根据角色查询角色权限
     * @param roleId 角色id
     * @return list
     */
    List<RoleMenu> findByRoleId(String roleId);
}
