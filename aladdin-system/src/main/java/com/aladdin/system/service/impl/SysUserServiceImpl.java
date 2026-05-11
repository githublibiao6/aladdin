package com.aladdin.system.service.impl;

import com.aladdin.common.db.base.BaseServiceImpl;
import com.aladdin.system.dao.SysUserDao;
import com.aladdin.system.entity.SysUser;
import com.aladdin.system.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * 系统用户服务实现
 *
 * @author cles
 * @date 2026/05/06
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUser> implements SysUserService {

    @Override
    public SysUser getByUsername(String username) {
        return dao.selectByUsername(username);
    }

    @Override
    public Set<String> getRoleKeysByUserId(Long userId) {
        return dao.selectRoleKeysByUserId(userId);
    }

    @Override
    public Set<String> getPermsByUserId(Long userId) {
        return dao.selectPermsByUserId(userId);
    }
}
