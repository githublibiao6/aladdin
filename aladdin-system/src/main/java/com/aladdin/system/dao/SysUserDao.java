package com.aladdin.system.dao;

import com.aladdin.common.db.base.BaseDao;
import com.aladdin.system.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

public interface SysUserDao extends BaseDao<SysUser> {

    @Select("SELECT * FROM sys_user WHERE username = #{username} AND sys005 = 1")
    SysUser selectByUsername(@Param("username") String username);

    @Select("SELECT r.role_key FROM sys_role r " +
            "INNER JOIN sys_user_role ur ON r.id = ur.role_id " +
            "WHERE ur.user_id = #{userId} AND r.sys005 = 1")
    Set<String> selectRoleKeysByUserId(@Param("userId") Long userId);

    @Select("SELECT m.perms FROM sys_menu m " +
            "INNER JOIN sys_role_menu rm ON m.id = rm.menu_id " +
            "INNER JOIN sys_user_role ur ON rm.role_id = ur.role_id " +
            "WHERE ur.user_id = #{userId} AND m.sys005 = 1")
    Set<String> selectPermsByUserId(@Param("userId") Long userId);
}
