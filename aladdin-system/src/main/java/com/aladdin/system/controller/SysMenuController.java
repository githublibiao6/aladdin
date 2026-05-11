package com.aladdin.system.controller;

import com.aladdin.common.core.domain.R;
import com.aladdin.system.entity.SysMenu;
import com.aladdin.system.service.SysMenuService;
import org.springframework.web.bind.annotation.*;

/**
 * 系统菜单控制：" *
 * @author cles
 * @date 2026/05/06
 */
@RestController
@RequestMapping("/menu")
public class SysMenuController {

    private final SysMenuService sysMenuService;

    public SysMenuController(SysMenuService sysMenuService) {
        this.sysMenuService = sysMenuService;
    }

    @GetMapping("/{id}")
    public R<SysMenu> getById(@PathVariable Long id) {
        return R.ok(sysMenuService.getById(id));
    }

    @PostMapping
    public R<Void> save(@RequestBody SysMenu menu) {
        return sysMenuService.save(menu) ? R.ok() : R.fail();
    }

    @PutMapping
    public R<Void> update(@RequestBody SysMenu menu) {
        return sysMenuService.updateById(menu) ? R.ok() : R.fail();
    }

    @DeleteMapping("/{id}")
    public R<Void> remove(@PathVariable Long id) {
        return sysMenuService.removeById(id) ? R.ok() : R.fail();
    }
}
