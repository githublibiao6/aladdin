package com.aladdin.system.controller;

import com.aladdin.common.core.cache.DictCacheService;
import com.aladdin.common.core.domain.R;
import com.aladdin.system.entity.SysDictData;
import com.aladdin.system.entity.SysDictType;
import com.aladdin.system.service.SysDictDataService;
import com.aladdin.system.service.SysDictTypeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统字典数据控制器
 *
 * @author cles
 * @date 2026/05/06
 */
@RestController
@RequestMapping("/dict/data")
public class SysDictDataController {

    private final SysDictDataService sysDictDataService;
    private final SysDictTypeService sysDictTypeService;
    private final DictCacheService dictCacheService;

    public SysDictDataController(SysDictDataService sysDictDataService,
                                 SysDictTypeService sysDictTypeService,
                                 DictCacheService dictCacheService) {
        this.sysDictDataService = sysDictDataService;
        this.sysDictTypeService = sysDictTypeService;
        this.dictCacheService = dictCacheService;
    }

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('system:dict:list')")
    public R<List<SysDictData>> listByTypeId(@RequestParam Long dictTypeId) {
        return R.ok(sysDictDataService.listByDictTypeId(dictTypeId));
    }

    @GetMapping("/detail/{id}")
    @PreAuthorize("hasAuthority('system:dict:list')")
    public R<SysDictData> getById(@PathVariable Long id) {
        return R.ok(sysDictDataService.getById(id));
    }

    @GetMapping("/type/{dictType}")
    public R<List<SysDictData>> listByDictType(@PathVariable String dictType) {
        return R.ok(sysDictDataService.listByDictType(dictType));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('system:dict:add')")
    public R<Void> save(@RequestBody SysDictData dictData) {
        boolean result = sysDictDataService.save(dictData);
        if (result) {
            dictCacheService.removeDict(getDictTypeStr(dictData.getDictTypeId()));
        }
        return result ? R.ok() : R.fail();
    }

    @PostMapping("/edit")
    @PreAuthorize("hasAuthority('system:dict:edit')")
    public R<Void> update(@RequestBody SysDictData dictData) {
        boolean result = sysDictDataService.updateById(dictData);
        if (result) {
            dictCacheService.removeDict(getDictTypeStr(dictData.getDictTypeId()));
        }
        return result ? R.ok() : R.fail();
    }

    @PostMapping("/remove/{id}")
    @PreAuthorize("hasAuthority('system:dict:remove')")
    public R<Void> remove(@PathVariable Long id) {
        SysDictData dictData = sysDictDataService.getById(id);
        boolean result = sysDictDataService.removeById(id);
        if (result && dictData != null) {
            dictCacheService.removeDict(getDictTypeStr(dictData.getDictTypeId()));
        }
        return result ? R.ok() : R.fail();
    }

    @PostMapping("/refreshCache")
    @PreAuthorize("hasAuthority('system:dict:edit')")
    public R<Void> refreshCache() {
        dictCacheService.clearAll();
        return R.ok();
    }

    private String getDictTypeStr(Long dictTypeId) {
        if (dictTypeId == null) {
            return null;
        }
        SysDictType dictType = sysDictTypeService.getById(dictTypeId);
        return dictType != null ? dictType.getDictType() : null;
    }
}
