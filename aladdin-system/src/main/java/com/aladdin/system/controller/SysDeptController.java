package com.aladdin.system.controller;

import com.aladdin.common.core.domain.R;
import com.aladdin.system.entity.SysDept;
import com.aladdin.system.service.SysDeptService;
import org.springframework.web.bind.annotation.*;

/**
 * 系统部门控制：" *
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

    @GetMapping("/{id}")
    public R<SysDept> getById(@PathVariable Long id) {
        return R.ok(sysDeptService.getById(id));
    }

    @PostMapping
    public R<Void> save(@RequestBody SysDept dept) {
        return sysDeptService.save(dept) ? R.ok() : R.fail();
    }

    @PutMapping
    public R<Void> update(@RequestBody SysDept dept) {
        return sysDeptService.updateById(dept) ? R.ok() : R.fail();
    }

    @DeleteMapping("/{id}")
    public R<Void> remove(@PathVariable Long id) {
        return sysDeptService.removeById(id) ? R.ok() : R.fail();
    }
}
