package com.aladdin.system.controller;

import com.aladdin.common.core.domain.R;
import com.aladdin.system.entity.SysDictType;
import com.aladdin.system.service.SysDictTypeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统字典类型控制器
 *
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

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('system:dict:list')")
    public R<List<SysDictType>> list() {
        return R.ok(sysDictTypeService.listAll());
    }

    @GetMapping("/detail/{id}")
    @PreAuthorize("hasAuthority('system:dict:list')")
    public R<SysDictType> getById(@PathVariable Long id) {
        return R.ok(sysDictTypeService.getById(id));
    }

    @GetMapping("/type/{dictType}")
    public R<SysDictType> getByDictType(@PathVariable String dictType) {
        return R.ok(sysDictTypeService.getByDictType(dictType));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('system:dict:add')")
    public R<Void> save(@RequestBody SysDictType dictType) {
        return sysDictTypeService.save(dictType) ? R.ok() : R.fail();
    }

    @PostMapping("/edit")
    @PreAuthorize("hasAuthority('system:dict:edit')")
    public R<Void> update(@RequestBody SysDictType dictType) {
        return sysDictTypeService.updateById(dictType) ? R.ok() : R.fail();
    }

    @PostMapping("/remove/{id}")
    @PreAuthorize("hasAuthority('system:dict:remove')")
    public R<Void> remove(@PathVariable Long id) {
        return sysDictTypeService.removeById(id) ? R.ok() : R.fail();
    }
}
