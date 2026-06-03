package com.aladdin.system.controller;

import com.aladdin.common.core.domain.R;
import com.aladdin.common.security.service.LoginService;
import com.aladdin.system.entity.SysMenu;
import com.aladdin.system.entity.SysRole;
import com.aladdin.system.entity.SysUser;
import com.aladdin.system.service.SysMenuService;
import com.aladdin.system.service.SysRoleService;
import com.aladdin.system.service.SysUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class SysUserController {

    private final SysUserService sysUserService;
    private final SysRoleService sysRoleService;
    private final SysMenuService sysMenuService;
    private final PasswordEncoder passwordEncoder;

    public SysUserController(SysUserService sysUserService, SysRoleService sysRoleService,
                             SysMenuService sysMenuService, PasswordEncoder passwordEncoder) {
        this.sysUserService = sysUserService;
        this.sysRoleService = sysRoleService;
        this.sysMenuService = sysMenuService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('system:user:list')")
    public R<List<SysUser>> list() {
        return R.ok(sysUserService.list());
    }

    @GetMapping("/detail/{id}")
    @PreAuthorize("hasAuthority('system:user:list')")
    public R<SysUser> getById(@PathVariable Long id) {
        return R.ok(sysUserService.getById(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('system:user:add')")
    public R<Void> save(@RequestBody SysUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return sysUserService.save(user) ? R.ok() : R.fail();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('system:user:edit')")
    public R<Void> update(@RequestBody SysUser user) {
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        } else {
            SysUser existing = sysUserService.getById(user.getId());
            if (existing != null) {
                user.setPassword(existing.getPassword());
            }
        }
        return sysUserService.updateById(user) ? R.ok() : R.fail();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('system:user:remove')")
    public R<Void> remove(@PathVariable Long id) {
        return sysUserService.removeById(id) ? R.ok() : R.fail();
    }

    @GetMapping("/info")
    public R<Map<String, Object>> getCurrentUserInfo() {
        Long userId = LoginService.getCurrentUserId();
        if (userId == null) {
            return R.fail(401, "未登录");
        }
        SysUser user = sysUserService.getById(userId);
        if (user == null) {
            return R.fail(401, "用户不存在");
        }
        user.setPassword(null);

        List<SysRole> roles = sysRoleService.getRolesByUserId(userId);
        List<SysMenu> menus = sysMenuService.getMenusByUserId(userId);
        Set<String> perms = sysUserService.getPermsByUserId(userId);

        Map<String, Object> data = new HashMap<>();
        data.put("user", user);
        data.put("roles", roles);
        data.put("menus", menus);
        data.put("permissions", perms);
        return R.ok(data);
    }

    @GetMapping("/permissions")
    public R<Set<String>> getCurrentUserPermissions() {
        Long userId = LoginService.getCurrentUserId();
        if (userId == null) {
            return R.fail(401, "未登录");
        }
        Set<String> roleKeys = sysUserService.getRoleKeysByUserId(userId);
        Set<String> perms = sysUserService.getPermsByUserId(userId);
        Set<String> all = new HashSet<>();
        for (String roleKey : roleKeys) {
            all.add("ROLE_" + roleKey);
        }
        all.addAll(perms);
        return R.ok(all);
    }
}
