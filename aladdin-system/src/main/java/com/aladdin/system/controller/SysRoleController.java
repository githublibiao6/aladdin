package com.aladdin.system.controller;

import com.aladdin.common.core.domain.R;
import com.aladdin.system.entity.SysRole;
import com.aladdin.system.service.SysRoleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class SysRoleController {

    private final SysRoleService sysRoleService;

    public SysRoleController(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('system:role:list')")
    public R<List<SysRole>> list() {
        return R.ok(sysRoleService.list());
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("hasAuthority('system:role:list')")
    public R<List<SysRole>> getUserRoles(@PathVariable Long userId) {
        return R.ok(sysRoleService.getRolesByUserId(userId));
    }

    @GetMapping("/detail/{id}")
    @PreAuthorize("hasAuthority('system:role:list')")
    public R<SysRole> getById(@PathVariable Long id) {
        return R.ok(sysRoleService.getById(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('system:role:add')")
    public R<Void> save(@RequestBody SysRole role) {
        return sysRoleService.save(role) ? R.ok() : R.fail();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('system:role:edit')")
    public R<Void> update(@RequestBody SysRole role) {
        return sysRoleService.updateById(role) ? R.ok() : R.fail();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('system:role:remove')")
    public R<Void> remove(@PathVariable Long id) {
        return sysRoleService.removeById(id) ? R.ok() : R.fail();
    }

    @PostMapping("/assignMenus")
    @PreAuthorize("hasAuthority('system:role:edit')")
    public R<Void> assignMenus(@RequestBody Map<String, Object> body) {
        Long roleId = Long.valueOf(body.get("roleId").toString());
        @SuppressWarnings("unchecked")
        List<Long> menuIds = (List<Long>) body.get("menuIds");
        sysRoleService.assignMenus(roleId, menuIds);
        return R.ok();
    }

    @PostMapping("/assignRoles")
    @PreAuthorize("hasAuthority('system:user:edit')")
    public R<Void> assignRoles(@RequestBody Map<String, Object> body) {
        Long userId = Long.valueOf(body.get("userId").toString());
        @SuppressWarnings("unchecked")
        List<Long> roleIds = (List<Long>) body.get("roleIds");
        sysRoleService.assignRoles(userId, roleIds);
        return R.ok();
    }
}
