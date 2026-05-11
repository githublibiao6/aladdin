package com.aladdin.system.controller;

import com.aladdin.common.core.domain.R;
import com.aladdin.system.entity.SysDictType;
import com.aladdin.system.service.SysDictTypeService;
import org.springframework.web.bind.annotation.*;

/**
 * 系统字典类型控制：" *
 * @author cles
 * @date 2026/05/06
 */
@RestController
@RequestMapping("/dict/type")
public class SysDictTypeController {

    private final SysDictTypeService sysDictTypeService;

    public SysDictTypeController(SysDictTypeService sysDictTypeService) {
        this.sysDictTypeService = sysDictTypeService;
    }

    @GetMapping("/{id}")
    public R<SysDictType> getById(@PathVariable Long id) {
        return R.ok(sysDictTypeService.getById(id));
    }

    @PostMapping
    public R<Void> save(@RequestBody SysDictType dictType) {
        return sysDictTypeService.save(dictType) ? R.ok() : R.fail();
    }

    @PutMapping
    public R<Void> update(@RequestBody SysDictType dictType) {
        return sysDictTypeService.updateById(dictType) ? R.ok() : R.fail();
    }

    @DeleteMapping("/{id}")
    public R<Void> remove(@PathVariable Long id) {
        return sysDictTypeService.removeById(id) ? R.ok() : R.fail();
    }
}
