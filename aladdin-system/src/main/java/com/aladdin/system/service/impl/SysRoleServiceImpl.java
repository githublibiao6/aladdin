package com.aladdin.system.service.impl;

import com.aladdin.common.db.base.BaseServiceImpl;
import com.aladdin.system.dao.SysRoleDao;
import com.aladdin.system.entity.SysRole;
import com.aladdin.system.service.SysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * 系统角色服务实现
 *
 * @author cles
 * @date 2026/05/06
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleDao, SysRole> implements SysRoleService {

    @Override
    public List<SysRole> getRolesByUserId(Long userId) {
        return getMapper().selectRolesByUserId(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void assignResources(Long roleId, List<Long> resourceIds) {
        getMapper().deleteRoleResourceByRoleId(roleId);
        if (resourceIds != null && !resourceIds.isEmpty()) {
            getMapper().batchInsertRoleResource(roleId, resourceIds);
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void assignDataScope(Long roleId, Integer dataScope, List<Long> deptIds) {
        SysRole role = getById(roleId);
        if (role == null) {
            return;
        }
        role.setDataScope(dataScope);
        updateById(role);
        getMapper().deleteRoleDeptByRoleId(roleId);
        if (deptIds != null && !deptIds.isEmpty() && dataScope == 2) {
            getMapper().batchInsertRoleDept(roleId, deptIds);
        }
    }

    @Override
    public List<Long> getDeptIdsByRoleId(Long roleId) {
        return getMapper().selectDeptIdsByRoleId(roleId);
    }
}
