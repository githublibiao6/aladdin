package com.aladdin.mis.dao.manager;

import com.aladdin.mis.manager.bean.RoleMenu;
import com.aladdin.mis.manager.vo.RoleMenuVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 菜单dao
* @Description
* @MethodName  RoleDao
* @author lb
* @date 2018年8月20日 下午11:14:28
*
 */
@Component
public interface RoleMenuDao {

    /**
     * 功能描述：
     *  < 删除角色的菜单 >
     * @Description: removeByRoleId
     * @Author: cles
     * @Date: 2020/7/8 22:42
     * @param roleId 参数1
     * @return: com.apps.omnipotent.manager.bean.RoleMenu
     * @version: 1.0.0
     */
    int removeByRoleId(@Param("roleId") Integer roleId);

    /**
     * 功能描述：
     *  < 根据菜单和角色查询菜单角色关联 >
     * @Description: findByMenuAndRole
     * @Author: cles
     * @Date: 2020/7/8 22:42
     * @param roleId 参数1
     * @return: com.apps.omnipotent.manager.bean.RoleMenu
     * @version: 1.0.0
     */
    List<RoleMenu> findByRoleId(@Param("roleId") Integer roleId);

    /**
     * 功能描述：
     *  < 根据菜单和角色查询菜单角色关联 >
     * @Description: findByMenuAndRole
     * @Author: cles
     * @Date: 2020/7/8 22:42
     * @param roles 参数1
     * @return: com.apps.omnipotent.manager.bean.RoleMenu
     * @version: 1.0.0
     */
    List<RoleMenuVo> findByRoleIds(@Param("roles") List<Integer> roles);
}
