package com.aladdin.system.controller;

import com.aladdin.common.core.domain.R;
import com.aladdin.system.entity.SysDictData;
import com.aladdin.system.service.SysDictDataService;
import org.springframework.web.bind.annotation.*;

/**
 * 系统字典数据控制：" *
 * @author cles
 * @date 2026/05/06
 */
@RestController
@RequestMapping("/dict/data")
public class SysDictDataController {

    private final SysDictDataService sysDictDataService;

    public SysDictDataController(SysDictDataService sysDictDataService) {
        this.sysDictDataService = sysDictDataService;
    }

    @GetMapping("/{id}")
    public R<SysDictData> getById(@PathVariable Long id) {
        return R.ok(sysDictDataService.getById(id));
    }

    @PostMapping
    public R<Void> save(@RequestBody SysDictData dictData) {
        return sysDictDataService.save(dictData) ? R.ok() : R.fail();
    }

    @PutMapping
    public R<Void> update(@RequestBody SysDictData dictData) {
        return sysDictDataService.updateById(dictData) ? R.ok() : R.fail();
    }

    @DeleteMapping("/{id}")
    public R<Void> remove(@PathVariable Long id) {
        return sysDictDataService.removeById(id) ? R.ok() : R.fail();
    }
}
