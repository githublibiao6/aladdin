package com.aladdin.system.service;

import com.aladdin.common.db.base.BaseService;
import com.aladdin.system.entity.SysUserGroup;

import java.util.List;
import java.util.Set;

/**
 * 用户组服务接口
 *
 * @author cles
 * @date 2026/06/12
 */
public interface SysUserGroupService extends BaseService<SysUserGroup> {

    /** 用户组关联角色 */
    void assignRoles(Long groupId, List<Long> roleIds);

    /** 用户组关联用户 */
    void assignUsers(Long groupId, List<Long> userIds);

    /** 获取用户组关联的角色ID列表 */
    List<Long> getRoleIdsByGroupId(Long groupId);

    /** 获取用户组关联的用户ID列表 */
    List<Long> getUserIdsByGroupId(Long groupId);

    /** 通过用户ID获取用户组关联的角色key */
    Set<String> getRoleKeysByUserId(Long userId);

    /** 通过用户ID获取用户组关联的权限 */
    Set<String> getPermsByUserId(Long userId);
}
