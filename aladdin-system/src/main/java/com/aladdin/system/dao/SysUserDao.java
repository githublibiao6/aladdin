package com.aladdin.system.dao;

import com.aladdin.common.db.base.BaseDao;
import com.aladdin.system.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * 系统用户DAO
 *
 * @author cles
 * @date 2026/05/06
 */
public interface SysUserDao extends BaseDao<SysUser> {

    @Select("SELECT * FROM sys_user WHERE username = #{username} AND sys005 = 1")
    SysUser selectByUsername(@Param("username") String username);

    @Select("SELECT r.role_key FROM sys_role r " +
            "INNER JOIN sys_user_role ur ON r.id = ur.role_id " +
            "WHERE ur.user_id = #{userId} AND r.sys005 = 1")
    Set<String> selectRoleKeysByUserId(@Param("userId") Long userId);

    @Select("SELECT res.perms FROM sys_resource res " +
            "INNER JOIN sys_role_resource rr ON res.id = rr.resource_id " +
            "INNER JOIN sys_user_role ur ON rr.role_id = ur.role_id " +
            "WHERE ur.user_id = #{userId} AND res.sys005 = 1")
    Set<String> selectPermsByUserId(@Param("userId") Long userId);

    @Select("SELECT u.*, d.dept_name FROM sys_user u " +
            "LEFT JOIN sys_dept d ON u.dept_id = d.id " +
            "WHERE u.id = #{id} AND u.sys005 = 1")
    SysUser selectUserWithDeptById(@Param("id") Long id);

    @Update("UPDATE sys_user SET password = #{password} WHERE id = #{id}")
    int updatePassword(@Param("id") Long id, @Param("password") String password);

    @Update("UPDATE sys_user SET status = #{status} WHERE id = #{id}")
    int updateStatus(@Param("id") Long id, @Param("status") Integer status);

    @Update("UPDATE sys_user SET password = #{password}, pwd_change_time = #{pwdChangeTime}, pwd_force_change = 0 WHERE id = #{id}")
    int updatePasswordWithTime(@Param("id") Long id, @Param("password") String password, @Param("pwdChangeTime") LocalDateTime pwdChangeTime);

    @Update("UPDATE sys_user SET pwd_force_change = #{forceChange} WHERE id = #{id}")
    int updatePwdForceChange(@Param("id") Long id, @Param("forceChange") Integer forceChange);

    @Select("SELECT * FROM sys_user WHERE username = #{username} AND tenant_id = #{tenantId} AND sys005 = 1")
    SysUser selectByUsernameAndTenantId(@Param("username") String username, @Param("tenantId") Long tenantId);
}
