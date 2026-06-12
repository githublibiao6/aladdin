package com.aladdin.system.dao;

import com.aladdin.common.db.base.BaseDao;
import com.aladdin.system.entity.SysResource;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 系统资源DAO
 *
 * @author cles
 * @date 2026/06/11
 */
public interface SysResourceDao extends BaseDao<SysResource> {

    @Select("SELECT r.* FROM sys_resource r " +
            "INNER JOIN sys_role_resource rr ON r.id = rr.resource_id " +
            "INNER JOIN sys_user_role ur ON rr.role_id = ur.role_id " +
            "WHERE ur.user_id = #{userId} AND r.sys005 = 1 " +
            "ORDER BY r.sort")
    List<SysResource> selectResourcesByUserId(@Param("userId") Long userId);

    @Select("SELECT DISTINCT r.perms FROM sys_resource r " +
            "INNER JOIN sys_role_resource rr ON r.id = rr.resource_id " +
            "INNER JOIN sys_user_role ur ON rr.role_id = ur.role_id " +
            "WHERE ur.user_id = #{userId} AND r.sys005 = 1 AND r.perms IS NOT NULL AND r.perms != ''")
    List<String> selectPermsByUserId(@Param("userId") Long userId);

    @Select("SELECT r.* FROM sys_resource r " +
            "INNER JOIN sys_role_resource rr ON r.id = rr.resource_id " +
            "WHERE rr.role_id = #{roleId} AND r.sys005 = 1 " +
            "ORDER BY r.sort")
    List<SysResource> selectResourcesByRoleId(@Param("roleId") Long roleId);
}
