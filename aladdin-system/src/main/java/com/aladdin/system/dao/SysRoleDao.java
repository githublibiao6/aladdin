package com.aladdin.system.dao;

import com.aladdin.common.db.base.BaseDao;
import com.aladdin.system.entity.SysRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 系统角色DAO
 *
 * @author cles
 * @date 2026/05/06
 */
public interface SysRoleDao extends BaseDao<SysRole> {

    @Select("SELECT r.* FROM sys_role r " +
            "INNER JOIN sys_user_role ur ON r.id = ur.role_id " +
            "WHERE ur.user_id = #{userId} AND r.sys005 = 1")
    List<SysRole> selectRolesByUserId(@Param("userId") Long userId);

    @Insert("<script>" +
            "INSERT INTO sys_role_resource (role_id, resource_id) VALUES " +
            "<foreach collection='resourceIds' item='resourceId' separator=','>" +
            "(#{roleId}, #{resourceId})" +
            "</foreach>" +
            "</script>")
    int batchInsertRoleResource(@Param("roleId") Long roleId, @Param("resourceIds") List<Long> resourceIds);

    @Delete("DELETE FROM sys_role_resource WHERE role_id = #{roleId}")
    int deleteRoleResourceByRoleId(@Param("roleId") Long roleId);

    @Insert("<script>" +
            "INSERT INTO sys_user_role (user_id, role_id) VALUES " +
            "<foreach collection='roleIds' item='roleId' separator=','>" +
            "(#{userId}, #{roleId})" +
            "</foreach>" +
            "</script>")
    int batchInsertUserRole(@Param("userId") Long userId, @Param("roleIds") List<Long> roleIds);

    @Delete("DELETE FROM sys_user_role WHERE user_id = #{userId}")
    int deleteUserRoleByUserId(@Param("userId") Long userId);

    @Insert("<script>" +
            "INSERT INTO sys_role_dept (role_id, dept_id) VALUES " +
            "<foreach collection='deptIds' item='deptId' separator=','>" +
            "(#{roleId}, #{deptId})" +
            "</foreach>" +
            "</script>")
    int batchInsertRoleDept(@Param("roleId") Long roleId, @Param("deptIds") List<Long> deptIds);

    @Delete("DELETE FROM sys_role_dept WHERE role_id = #{roleId}")
    int deleteRoleDeptByRoleId(@Param("roleId") Long roleId);

    @Select("SELECT dept_id FROM sys_role_dept WHERE role_id = #{roleId}")
    List<Long> selectDeptIdsByRoleId(@Param("roleId") Long roleId);
}
