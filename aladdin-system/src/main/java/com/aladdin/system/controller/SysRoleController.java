package com.aladdin.system.controller;

import com.aladdin.common.core.domain.R;
import com.aladdin.system.entity.SysRole;
import com.aladdin.system.service.SysRoleService;
import org.springframework.web.bind.annotation.*;

/**
 * 系统角色控制：" *
 * @author cles
 * @date 2026/05/06
 */
@RestController
@RequestMapping("/role")
public class SysRoleController {

    private final SysRoleService sysRoleService;

    public SysRoleController(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    @GetMapping("/{id}")
    public R<SysRole> getById(@PathVariable Long id) {
        return R.ok(sysRoleService.getById(id));
    }

    @PostMapping
    public R<Void> save(@RequestBody SysRole role) {
        return sysRoleService.save(role) ? R.ok() : R.fail();
    }

    @PutMapping
    public R<Void> update(@RequestBody SysRole role) {
        return sysRoleService.updateById(role) ? R.ok() : R.fail();
    }

    @DeleteMapping("/{id}")
    public R<Void> remove(@PathVariable Long id) {
        return sysRoleService.removeById(id) ? R.ok() : R.fail();
    }
}
