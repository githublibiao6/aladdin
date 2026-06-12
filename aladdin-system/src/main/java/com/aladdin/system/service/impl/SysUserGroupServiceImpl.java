package com.aladdin.system.service.impl;

import com.aladdin.common.db.base.BaseServiceImpl;
import com.aladdin.system.dao.SysUserGroupDao;
import com.aladdin.system.entity.SysUserGroup;
import com.aladdin.system.service.SysUserGroupService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 用户组服务实现
 *
 * @author cles
 * @date 2026/06/12
 */
@Service
public class SysUserGroupServiceImpl extends BaseServiceImpl<SysUserGroupDao, SysUserGroup> implements SysUserGroupService {

    private final JdbcTemplate jdbcTemplate;

    public SysUserGroupServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public void assignRoles(Long groupId, List<Long> roleIds) {
        jdbcTemplate.update("DELETE FROM sys_user_group_role WHERE group_id = ?", groupId);
        for (Long roleId : roleIds) {
            jdbcTemplate.update("INSERT INTO sys_user_group_role (group_id, role_id) VALUES (?, ?)", groupId, roleId);
        }
    }

    @Override
    @Transactional
    public void assignUsers(Long groupId, List<Long> userIds) {
        jdbcTemplate.update("DELETE FROM sys_user_group_user WHERE group_id = ?", groupId);
        for (Long userId : userIds) {
            jdbcTemplate.update("INSERT INTO sys_user_group_user (group_id, user_id) VALUES (?, ?)", groupId, userId);
        }
    }

    @Override
    public List<Long> getRoleIdsByGroupId(Long groupId) {
        return jdbcTemplate.queryForList("SELECT role_id FROM sys_user_group_role WHERE group_id = ?",
                Long.class, groupId);
    }

    @Override
    public List<Long> getUserIdsByGroupId(Long groupId) {
        return jdbcTemplate.queryForList("SELECT user_id FROM sys_user_group_user WHERE group_id = ?",
                Long.class, groupId);
    }

    @Override
    public Set<String> getRoleKeysByUserId(Long userId) {
        return getMapper().selectRoleKeysByUserId(userId);
    }

    @Override
    public Set<String> getPermsByUserId(Long userId) {
        return getMapper().selectPermsByUserId(userId);
    }
}
