package com.aladdin.system.controller;

import com.aladdin.common.core.domain.R;
import com.aladdin.common.security.service.LoginService;
import com.aladdin.system.entity.SysUser;
import com.aladdin.system.service.SysUserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * 系统用户控制：" *
 * @author cles
 * @date 2026/05/06
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    private final SysUserService sysUserService;
    private final PasswordEncoder passwordEncoder;

    public SysUserController(SysUserService sysUserService, PasswordEncoder passwordEncoder) {
        this.sysUserService = sysUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/{id}")
    public R<SysUser> getById(@PathVariable Long id) {
        return R.ok(sysUserService.getById(id));
    }

    @PostMapping
    public R<Void> save(@Valid @RequestBody SysUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return sysUserService.save(user) ? R.ok() : R.fail();
    }

    @PutMapping
    public R<Void> update(@RequestBody SysUser user) {
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return sysUserService.updateById(user) ? R.ok() : R.fail();
    }

    @DeleteMapping("/{id}")
    public R<Void> remove(@PathVariable Long id) {
        return sysUserService.removeById(id) ? R.ok() : R.fail();
    }

    @GetMapping("/info")
    public R<SysUser> getCurrentUserInfo() {
        Long userId = LoginService.getCurrentUserId();
        if (userId == null) {
            return R.fail(401, "未登：");
        }
        return R.ok(sysUserService.getById(userId));
    }
}
