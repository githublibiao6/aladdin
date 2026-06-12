package com.aladdin.system.controller;

import com.aladdin.common.core.domain.R;
import com.aladdin.common.core.exception.GlobalErrorCode;
import com.aladdin.common.security.service.LoginService;
import com.aladdin.system.entity.SysResource;
import com.aladdin.system.service.SysResourceService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资源管理控制器
 * 资源类型：M-菜单，A-接口，F-按钮
 *
 * @author cles
 * @date 2026/06/11
 */
@RestController
@RequestMapping("/resource")
public class SysResourceController {

    private final SysResourceService sysResourceService;

    public SysResourceController(SysResourceService sysResourceService) {
        this.sysResourceService = sysResourceService;
    }

    @GetMapping("/tree")
    @PreAuthorize("hasAuthority('system:resource:list')")
    public R<List<SysResource>> getResourceTree() {
        return R.ok(sysResourceService.getResourceTree());
    }

    @GetMapping("/user")
    public R<List<SysResource>> getUserResources() {
        Long userId = LoginService.getCurrentUserId();
        if (userId == null) {
            return R.fail(GlobalErrorCode.UNAUTHORIZED);
        }
        return R.ok(sysResourceService.getResourcesByUserId(userId));
    }

    @GetMapping("/role/{roleId}")
    @PreAuthorize("hasAuthority('system:role:list')")
    public R<List<SysResource>> getRoleResources(@PathVariable Long roleId) {
        return R.ok(sysResourceService.getResourcesByRoleId(roleId));
    }

    @GetMapping("/detail/{id}")
    @PreAuthorize("hasAuthority('system:resource:list')")
    public R<SysResource> getById(@PathVariable Long id) {
        return R.ok(sysResourceService.getById(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('system:resource:add')")
    public R<Void> save(@RequestBody SysResource resource) {
        return sysResourceService.save(resource) ? R.ok() : R.fail();
    }

    @PostMapping("/edit")
    @PreAuthorize("hasAuthority('system:resource:edit')")
    public R<Void> update(@RequestBody SysResource resource) {
        return sysResourceService.updateById(resource) ? R.ok() : R.fail();
    }

    @PostMapping("/remove/{id}")
    @PreAuthorize("hasAuthority('system:resource:remove')")
    public R<Void> remove(@PathVariable Long id) {
        return sysResourceService.removeById(id) ? R.ok() : R.fail();
    }
}
