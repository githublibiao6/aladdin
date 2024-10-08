package com.aladdin.mis.system.service;

import com.aladdin.mis.base.service.GlobalService;
import com.aladdin.mis.manager.bean.RoleMenu;
import com.aladdin.mis.manager.vo.RoleMenuVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Description: 角色service
* @Author: cles
* @Date: 2020/4/15 23:48
*/
public interface RoleMenuService extends GlobalService<RoleMenu> {

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
    boolean removeByRoleId(Integer roleId);

    /**
     * 根据角色查询角色权限
     * @param roleId 角色id
     * @return list
     */
    List<RoleMenu> findByRoleId(Integer roleId);

    /**
     * 根据多个角色查询角色权限
     * @param roles
     * @return
     */
    List<RoleMenuVo> findByRoleIds(List<Integer> roles);
}
