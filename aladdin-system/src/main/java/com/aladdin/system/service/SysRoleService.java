package com.aladdin.system.service;

import com.aladdin.common.db.base.BaseService;
import com.aladdin.system.entity.SysRole;

import java.util.List;

public interface SysRoleService extends BaseService<SysRole> {

    List<SysRole> getRolesByUserId(Long userId);

    void assignMenus(Long roleId, List<Long> menuIds);

    void assignRoles(Long userId, List<Long> roleIds);
}
