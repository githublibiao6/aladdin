package com.aladdin.system.controller;

import com.aladdin.common.core.domain.R;
import com.aladdin.common.security.service.LoginService;
import com.aladdin.system.entity.SysMenu;
import com.aladdin.system.service.SysMenuService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class SysMenuController {

    private final SysMenuService sysMenuService;

    public SysMenuController(SysMenuService sysMenuService) {
        this.sysMenuService = sysMenuService;
    }

    @GetMapping("/tree")
    @PreAuthorize("hasAuthority('system:menu:list')")
    public R<List<SysMenu>> getMenuTree() {
        return R.ok(sysMenuService.getMenuTree());
    }

    @GetMapping("/user")
    public R<List<SysMenu>> getUserMenus() {
        Long userId = LoginService.getCurrentUserId();
        if (userId == null) {
            return R.fail(401, "未登录");
        }
        return R.ok(sysMenuService.getMenusByUserId(userId));
    }

    @GetMapping("/role/{roleId}")
    @PreAuthorize("hasAuthority('system:role:list')")
    public R<List<SysMenu>> getRoleMenus(@PathVariable Long roleId) {
        return R.ok(sysMenuService.getMenusByRoleId(roleId));
    }

    @GetMapping("/detail/{id}")
    @PreAuthorize("hasAuthority('system:menu:list')")
    public R<SysMenu> getById(@PathVariable Long id) {
        return R.ok(sysMenuService.getById(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('system:menu:add')")
    public R<Void> save(@RequestBody SysMenu menu) {
        return sysMenuService.save(menu) ? R.ok() : R.fail();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('system:menu:edit')")
    public R<Void> update(@RequestBody SysMenu menu) {
        return sysMenuService.updateById(menu) ? R.ok() : R.fail();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('system:menu:remove')")
    public R<Void> remove(@PathVariable Long id) {
        return sysMenuService.removeById(id) ? R.ok() : R.fail();
    }
}
