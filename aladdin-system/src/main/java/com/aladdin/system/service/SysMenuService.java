package com.aladdin.system.service;

import com.aladdin.common.db.base.BaseService;
import com.aladdin.system.entity.SysMenu;

import java.util.List;

public interface SysMenuService extends BaseService<SysMenu> {

    List<SysMenu> getMenuTree();

    List<SysMenu> getMenusByUserId(Long userId);

    List<SysMenu> getMenusByRoleId(Long roleId);

    List<SysMenu> buildMenuTree(List<SysMenu> menus);
}
