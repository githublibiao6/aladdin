package com.aladdin.system.controller;

import com.aladdin.common.core.domain.R;
import com.aladdin.common.core.exception.GlobalErrorCode;
import com.aladdin.common.security.service.LoginService;
import com.aladdin.system.entity.SysResource;
import com.aladdin.system.entity.SysRole;
import com.aladdin.system.entity.SysUser;
import com.aladdin.system.service.SysResourceService;
import com.aladdin.system.service.SysRoleService;
import com.aladdin.system.service.SysUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 系统用户控制器
 *
 * @author cles
 * @date 2026/05/06
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    private final SysUserService sysUserService;
    private final SysRoleService sysRoleService;
    private final SysResourceService sysResourceService;
    private final PasswordEncoder passwordEncoder;

    public SysUserController(SysUserService sysUserService, SysRoleService sysRoleService,
                             SysResourceService sysResourceService, PasswordEncoder passwordEncoder) {
        this.sysUserService = sysUserService;
        this.sysRoleService = sysRoleService;
        this.sysResourceService = sysResourceService;
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
        SysUser user = sysUserService.getUserWithDeptById(id);
        if (user != null) {
            user.setPassword(null);
        }
        return R.ok(user);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('system:user:add')")
    public R<Void> save(@RequestBody SysUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return sysUserService.save(user) ? R.ok() : R.fail();
    }

    @PostMapping("/edit")
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

    @PostMapping("/remove/{id}")
    @PreAuthorize("hasAuthority('system:user:remove')")
    public R<Void> remove(@PathVariable Long id) {
        return sysUserService.removeById(id) ? R.ok() : R.fail();
    }

    @GetMapping("/info")
    public R<Map<String, Object>> getCurrentUserInfo() {
        Long userId = LoginService.getCurrentUserId();
        if (userId == null) {
            return R.fail(GlobalErrorCode.UNAUTHORIZED);
        }
        SysUser user = sysUserService.getById(userId);
        if (user == null) {
            return R.fail(GlobalErrorCode.USER_NOT_FOUND);
        }
        user.setPassword(null);

        List<SysRole> roles = sysRoleService.getRolesByUserId(userId);
        List<SysResource> resources = sysResourceService.getResourcesByUserId(userId);
        Set<String> perms = sysUserService.getPermsByUserId(userId);

        Map<String, Object> data = new HashMap<>();
        data.put("user", user);
        data.put("roles", roles);
        data.put("resources", resources);
        data.put("permissions", perms);
        return R.ok(data);
    }

    @GetMapping("/permissions")
    public R<Set<String>> getCurrentUserPermissions() {
        Long userId = LoginService.getCurrentUserId();
        if (userId == null) {
            return R.fail(GlobalErrorCode.UNAUTHORIZED);
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

    @PostMapping("/resetPassword")
    @PreAuthorize("hasAuthority('system:user:edit')")
    public R<Void> resetPassword(@RequestBody Map<String, Object> body) {
        Long id = Long.valueOf(body.get("id").toString());
        String password = (String) body.get("password");
        if (password == null || password.isEmpty()) {
            password = "123456";
        }
        return sysUserService.resetPassword(id, passwordEncoder.encode(password)) ? R.ok() : R.fail();
    }

    @PostMapping("/changeStatus")
    @PreAuthorize("hasAuthority('system:user:edit')")
    public R<Void> changeStatus(@RequestBody Map<String, Object> body) {
        Long id = Long.valueOf(body.get("id").toString());
        Integer status = Integer.valueOf(body.get("status").toString());
        return sysUserService.updateStatus(id, status) ? R.ok() : R.fail();
    }
}
