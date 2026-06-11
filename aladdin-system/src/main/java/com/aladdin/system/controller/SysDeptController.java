package com.aladdin.system.controller;

import com.aladdin.common.core.domain.R;
import com.aladdin.system.entity.SysDept;
import com.aladdin.system.service.SysDeptService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统部门控制器
 *
 * @author cles
 * @date 2026/05/06
 */
@RestController
@RequestMapping("/dept")
public class SysDeptController {

    private final SysDeptService sysDeptService;

    public SysDeptController(SysDeptService sysDeptService) {
        this.sysDeptService = sysDeptService;
    }

    @GetMapping("/tree")
    @PreAuthorize("hasAuthority('system:dept:list')")
    public R<List<SysDept>> getDeptTree() {
        return R.ok(sysDeptService.getDeptTree());
    }

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('system:dept:list')")
    public R<List<SysDept>> list() {
        return R.ok(sysDeptService.list());
    }

    @GetMapping("/detail/{id}")
    @PreAuthorize("hasAuthority('system:dept:list')")
    public R<SysDept> getById(@PathVariable Long id) {
        return R.ok(sysDeptService.getById(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('system:dept:add')")
    public R<Void> save(@RequestBody SysDept dept) {
        return sysDeptService.save(dept) ? R.ok() : R.fail();
    }

    @PostMapping("/edit")
    @PreAuthorize("hasAuthority('system:dept:edit')")
    public R<Void> update(@RequestBody SysDept dept) {
        return sysDeptService.updateById(dept) ? R.ok() : R.fail();
    }

    @PostMapping("/remove/{id}")
    @PreAuthorize("hasAuthority('system:dept:remove')")
    public R<Void> remove(@PathVariable Long id) {
        return sysDeptService.removeById(id) ? R.ok() : R.fail();
    }
}
