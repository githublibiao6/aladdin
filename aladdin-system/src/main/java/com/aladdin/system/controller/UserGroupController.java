package com.aladdin.system.controller;

import com.aladdin.common.core.domain.R;
import com.aladdin.system.entity.SysUserGroup;
import com.aladdin.system.service.SysUserGroupService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 用户组管理控制器
 *
 * @author cles
 * @date 2026/06/12
 */
@RestController
@RequestMapping("/userGroup")
public class UserGroupController {

    private final SysUserGroupService userGroupService;

    public UserGroupController(SysUserGroupService userGroupService) {
        this.userGroupService = userGroupService;
    }

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('system:userGroup:list')")
    public R<List<SysUserGroup>> list() {
        return R.ok(userGroupService.list());
    }

    @GetMapping("/detail/{id}")
    @PreAuthorize("hasAuthority('system:userGroup:list')")
    public R<SysUserGroup> getById(@PathVariable Long id) {
        return R.ok(userGroupService.getById(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('system:userGroup:add')")
    public R<Void> save(@RequestBody SysUserGroup group) {
        return userGroupService.save(group) ? R.ok() : R.fail();
    }

    @PostMapping("/edit")
    @PreAuthorize("hasAuthority('system:userGroup:edit')")
    public R<Void> update(@RequestBody SysUserGroup group) {
        return userGroupService.updateById(group) ? R.ok() : R.fail();
    }

    @PostMapping("/remove/{id}")
    @PreAuthorize("hasAuthority('system:userGroup:remove')")
    public R<Void> remove(@PathVariable Long id) {
        return userGroupService.removeById(id) ? R.ok() : R.fail();
    }

    /** 用户组关联角色 */
    @PostMapping("/assignRoles")
    @PreAuthorize("hasAuthority('system:userGroup:edit')")
    public R<Void> assignRoles(@RequestBody Map<String, Object> body) {
        Long groupId = Long.valueOf(body.get("groupId").toString());
        @SuppressWarnings("unchecked")
        List<Long> roleIds = (List<Long>) body.get("roleIds");
        userGroupService.assignRoles(groupId, roleIds);
        return R.ok();
    }

    /** 用户组关联用户 */
    @PostMapping("/assignUsers")
    @PreAuthorize("hasAuthority('system:userGroup:edit')")
    public R<Void> assignUsers(@RequestBody Map<String, Object> body) {
        Long groupId = Long.valueOf(body.get("groupId").toString());
        @SuppressWarnings("unchecked")
        List<Long> userIds = (List<Long>) body.get("userIds");
        userGroupService.assignUsers(groupId, userIds);
        return R.ok();
    }

    /** 获取用户组关联的角色 */
    @GetMapping("/roles/{groupId}")
    @PreAuthorize("hasAuthority('system:userGroup:list')")
    public R<List<Long>> getRoles(@PathVariable Long groupId) {
        return R.ok(userGroupService.getRoleIdsByGroupId(groupId));
    }

    /** 获取用户组关联的用户 */
    @GetMapping("/users/{groupId}")
    @PreAuthorize("hasAuthority('system:userGroup:list')")
    public R<List<Long>> getUsers(@PathVariable Long groupId) {
        return R.ok(userGroupService.getUserIdsByGroupId(groupId));
    }
}
