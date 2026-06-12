package com.aladdin.system.dao;

import com.aladdin.common.db.base.BaseDao;
import com.aladdin.system.entity.SysUserGroup;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * 用户组DAO
 *
 * @author cles
 * @date 2026/06/12
 */
public interface SysUserGroupDao extends BaseDao<SysUserGroup> {

    @Select("SELECT r.role_key FROM sys_role r " +
            "INNER JOIN sys_user_group_role ugr ON r.id = ugr.role_id " +
            "INNER JOIN sys_user_group_user ugu ON ugr.group_id = ugu.group_id " +
            "WHERE ugu.user_id = #{userId} AND r.sys005 = 1")
    Set<String> selectRoleKeysByUserId(@Param("userId") Long userId);

    @Select("SELECT res.perms FROM sys_resource res " +
            "INNER JOIN sys_role_resource rr ON res.id = rr.resource_id " +
            "INNER JOIN sys_user_group_role ugr ON rr.role_id = ugr.role_id " +
            "INNER JOIN sys_user_group_user ugu ON ugr.group_id = ugu.group_id " +
            "WHERE ugu.user_id = #{userId} AND res.sys005 = 1")
    Set<String> selectPermsByUserId(@Param("userId") Long userId);
}
