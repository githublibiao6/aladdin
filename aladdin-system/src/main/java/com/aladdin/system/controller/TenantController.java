package com.aladdin.system.controller;

import com.aladdin.common.core.domain.R;
import com.aladdin.system.entity.SysTenant;
import com.aladdin.system.service.SysTenantService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 租户管理控制器
 *
 * @author cles
 * @date 2026/06/12
 */
@RestController
@RequestMapping("/tenant")
public class TenantController {

    private final SysTenantService tenantService;

    public TenantController(SysTenantService tenantService) {
        this.tenantService = tenantService;
    }

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('system:tenant:list')")
    public R<List<SysTenant>> list() {
        return R.ok(tenantService.list());
    }

    @GetMapping("/detail/{id}")
    @PreAuthorize("hasAuthority('system:tenant:list')")
    public R<SysTenant> getById(@PathVariable Long id) {
        return R.ok(tenantService.getById(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('system:tenant:add')")
    public R<Void> save(@RequestBody SysTenant tenant) {
        return tenantService.save(tenant) ? R.ok() : R.fail();
    }

    @PostMapping("/edit")
    @PreAuthorize("hasAuthority('system:tenant:edit')")
    public R<Void> update(@RequestBody SysTenant tenant) {
        return tenantService.updateById(tenant) ? R.ok() : R.fail();
    }

    @PostMapping("/remove/{id}")
    @PreAuthorize("hasAuthority('system:tenant:remove')")
    public R<Void> remove(@PathVariable Long id) {
        return tenantService.removeById(id) ? R.ok() : R.fail();
    }
}
