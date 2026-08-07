package com.aladdin.system.controller;

import com.aladdin.common.core.annotation.OpLog;
import com.aladdin.common.core.domain.PageQuery;
import com.aladdin.common.core.domain.PageResult;
import com.aladdin.common.core.domain.R;
import com.aladdin.common.core.exception.BusinessException;
import com.aladdin.common.core.exception.GlobalErrorCode;
import com.aladdin.system.entity.SysRole;
import com.aladdin.system.service.SysRoleService;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static com.aladdin.system.entity.table.SysRoleTableDef.SYS_ROLE;

import java.util.List;
import java.util.Map;

/**
 * 系统角色控制器
 *
 * @author cles
 * @date 2026/05/06
 */
@RestController
@RequestMapping({"/role", "/system/role"})
public class SysRoleController {

    private final SysRoleService sysRoleService;

    public SysRoleController(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('system:role:list')")
    public R<PageResult<SysRole>> list(PageQuery pageQuery,
                                       @RequestParam(required = false) String roleName,
                                       @RequestParam(required = false) Integer status) {
        return R.ok(sysRoleService.listPage(pageQuery, roleName, status));
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("hasAuthority('system:role:list')")
    public R<List<SysRole>> getUserRoles(@PathVariable Long userId) {
        return R.ok(sysRoleService.getRolesByUserId(userId));
    }

    @GetMapping("/detail/{id}")
    @PreAuthorize("hasAuthority('system:role:list')")
    public R<SysRole> getById(@PathVariable Long id) {
        SysRole role = sysRoleService.getById(id);
        if (role != null) {
            role.setDeptIds(sysRoleService.getDeptIdsByRoleId(id));
        }
        return R.ok(role);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('system:role:add')")
    @OpLog(value = "新增角色", type = "role")
    public R<Void> save(@RequestBody SysRole role) {
        // 检查角色标识是否已存在
        SysRole existing = sysRoleService.getOne(QueryWrapper.create().where(SYS_ROLE.ROLE_KEY.eq(role.getRoleKey())));
        if (existing != null) {
            throw new BusinessException(GlobalErrorCode.DATA_DUPLICATE, "角色标识已存在");
        }
        return sysRoleService.save(role) ? R.ok() : R.fail();
    }

    @PostMapping("/edit")
    @PreAuthorize("hasAuthority('system:role:edit')")
    @OpLog(value = "修改角色", type = "role")
    public R<Void> update(@RequestBody SysRole role) {
        return sysRoleService.updateById(role) ? R.ok() : R.fail();
    }

    @PostMapping("/remove/{id}")
    @PreAuthorize("hasAuthority('system:role:remove')")
    @OpLog(value = "删除角色", type = "role")
    public R<Void> remove(@PathVariable Long id) {
        return sysRoleService.removeById(id) ? R.ok() : R.fail();
    }

    @PostMapping("/assignResources")
    @PreAuthorize("hasAuthority('system:role:edit')")
    @OpLog(value = "分配角色资源", type = "role")
    public R<Void> assignResources(@RequestBody Map<String, Object> body) {
        Long roleId = Long.valueOf(body.get("roleId").toString());
        @SuppressWarnings("unchecked")
        List<Long> resourceIds = (List<Long>) body.get("resourceIds");
        sysRoleService.assignResources(roleId, resourceIds);
        return R.ok();
    }

    @PostMapping("/assignRoles")
    @PreAuthorize("hasAuthority('system:user:edit')")
    @OpLog(value = "分配用户角色", type = "role")
    public R<Void> assignRoles(@RequestBody Map<String, Object> body) {
        Long userId = Long.valueOf(body.get("userId").toString());
        @SuppressWarnings("unchecked")
        List<Long> roleIds = (List<Long>) body.get("roleIds");
        sysRoleService.assignRoles(userId, roleIds);
        return R.ok();
    }

    @PostMapping("/assignDataScope")
    @PreAuthorize("hasAuthority('system:role:edit')")
    @OpLog(value = "分配数据权限", type = "role")
    public R<Void> assignDataScope(@RequestBody Map<String, Object> body) {
        Long roleId = Long.valueOf(body.get("roleId").toString());
        Integer dataScope = Integer.valueOf(body.get("dataScope").toString());
        @SuppressWarnings("unchecked")
        List<Long> deptIds = (List<Long>) body.get("deptIds");
        sysRoleService.assignDataScope(roleId, dataScope, deptIds);
        return R.ok();
    }
}
