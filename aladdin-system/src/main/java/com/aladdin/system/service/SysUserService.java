package com.aladdin.system.service;

import com.aladdin.common.db.base.BaseService;
import com.aladdin.system.entity.SysUser;

import java.util.Set;

/**
 * 系统用户服务接口
 *
 * @author cles
 * @date 2026/05/06
 */
public interface SysUserService extends BaseService<SysUser> {

    SysUser getByUsername(String username);

    Set<String> getRoleKeysByUserId(Long userId);

    Set<String> getPermsByUserId(Long userId);

    SysUser getUserWithDeptById(Long id);

    boolean resetPassword(Long id, String password);

    boolean updateStatus(Long id, Integer status);
}
