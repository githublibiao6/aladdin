package com.aladdin.system.service.impl;

import com.aladdin.common.db.base.BaseServiceImpl;
import com.aladdin.system.dao.SysUserDao;
import com.aladdin.system.entity.SysUser;
import com.aladdin.system.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUser> implements SysUserService {

    @Override
    public SysUser getByUsername(String username) {
        return getMapper().selectByUsername(username);
    }

    @Override
    public Set<String> getRoleKeysByUserId(Long userId) {
        return getMapper().selectRoleKeysByUserId(userId);
    }

    @Override
    public Set<String> getPermsByUserId(Long userId) {
        return getMapper().selectPermsByUserId(userId);
    }

    @Override
    public SysUser getUserWithDeptById(Long id) {
        return getMapper().selectUserWithDeptById(id);
    }

    @Override
    public boolean resetPassword(Long id, String password) {
        return getMapper().updatePassword(id, password) > 0;
    }

    @Override
    public boolean updateStatus(Long id, Integer status) {
        return getMapper().updateStatus(id, status) > 0;
    }
}
