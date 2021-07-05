package com.apps.omnipotent.manager.dao;

import com.apps.omnipotent.manager.bean.Role;
import com.apps.omnipotent.manager.bean.RoleMenu;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
public interface RoleMenuMapper {

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
    @Update("update be_role_menu set sys005='0' where role_id=#{roleId} ")
    int removeByRoleId(String roleId);


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
    @Select("select * from be_role_menu where role_id=#{roleId} and sys005='1'")
    List<RoleMenu> findByRoleId(String roleId);
}
