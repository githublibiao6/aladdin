package com.aladdin.system.service.impl;

import com.aladdin.common.db.base.BaseServiceImpl;
import com.aladdin.system.dao.SysRoleDao;
import com.aladdin.system.entity.SysRole;
import com.aladdin.system.service.SysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleDao, SysRole> implements SysRoleService {

    @Override
    public List<SysRole> getRolesByUserId(Long userId) {
        return getMapper().selectRolesByUserId(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void assignMenus(Long roleId, List<Long> menuIds) {
        getMapper().deleteRoleMenuByRoleId(roleId);
        if (menuIds != null && !menuIds.isEmpty()) {
            getMapper().batchInsertRoleMenu(roleId, menuIds);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void assignRoles(Long userId, List<Long> roleIds) {
        getMapper().deleteUserRoleByUserId(userId);
        if (roleIds != null && !roleIds.isEmpty()) {
            getMapper().batchInsertUserRole(userId, roleIds);
        }
    }
}
