package com.aladdin.system.controller;

import com.aladdin.common.core.annotation.OpLog;
import com.aladdin.common.core.domain.PageQuery;
import com.aladdin.common.core.domain.PageResult;
import com.aladdin.common.core.domain.R;
import com.aladdin.common.core.exception.BusinessException;
import com.aladdin.common.core.exception.GlobalErrorCode;
import com.aladdin.system.entity.SysDictType;
import com.aladdin.system.service.SysDictTypeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 系统字典类型控制器
 *
 * @author cles
 * @date 2026/05/06
 */
@RestController
@RequestMapping({"/dict/type", "/system/dict/type"})
public class SysDictTypeController {

    private final SysDictTypeService sysDictTypeService;

    public SysDictTypeController(SysDictTypeService sysDictTypeService) {
        this.sysDictTypeService = sysDictTypeService;
    }

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('system:dict:list')")
    public R<PageResult<SysDictType>> list(PageQuery pageQuery,
                                            @RequestParam(required = false) String dictName,
                                            @RequestParam(required = false) Integer status) {
        return R.ok(sysDictTypeService.listPage(pageQuery, dictName, status));
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
    @OpLog(value = "新增字典类型", type = "dict")
    public R<Void> save(@RequestBody SysDictType dictType) {
        // 检查字典类型是否已存在
        if (sysDictTypeService.getByDictType(dictType.getDictType()) != null) {
            throw new BusinessException(GlobalErrorCode.DATA_DUPLICATE, "字典类型已存在");
        }
        return sysDictTypeService.save(dictType) ? R.ok() : R.fail();
    }

    @PostMapping("/edit")
    @PreAuthorize("hasAuthority('system:dict:edit')")
    @OpLog(value = "修改字典类型", type = "dict")
    public R<Void> update(@RequestBody SysDictType dictType) {
        return sysDictTypeService.updateById(dictType) ? R.ok() : R.fail();
    }

    @PostMapping("/remove/{id}")
    @PreAuthorize("hasAuthority('system:dict:remove')")
    @OpLog(value = "删除字典类型", type = "dict")
    public R<Void> remove(@PathVariable Long id) {
        return sysDictTypeService.removeById(id) ? R.ok() : R.fail();
    }
}
