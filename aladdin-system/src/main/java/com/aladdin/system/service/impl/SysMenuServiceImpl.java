package com.aladdin.system.service.impl;

import com.aladdin.common.db.base.BaseServiceImpl;
import com.aladdin.system.dao.SysMenuDao;
import com.aladdin.system.entity.SysMenu;
import com.aladdin.system.service.SysMenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuDao, SysMenu> implements SysMenuService {

    @Override
    public List<SysMenu> getMenuTree() {
        List<SysMenu> allMenus = list();
        return buildMenuTree(allMenus);
    }

    @Override
    public List<SysMenu> getMenusByUserId(Long userId) {
        List<SysMenu> menus = getMapper().selectMenusByUserId(userId);
        return buildMenuTree(menus);
    }

    @Override
    public List<SysMenu> getMenusByRoleId(Long roleId) {
        return getMapper().selectMenusByRoleId(roleId);
    }

    @Override
    public List<SysMenu> buildMenuTree(List<SysMenu> menus) {
        Map<Long, List<SysMenu>> grouped = menus.stream()
                .collect(Collectors.groupingBy(SysMenu::getParentId));
        menus.forEach(m -> m.setChildren(grouped.getOrDefault(m.getId(), new ArrayList<>())));
        return menus.stream()
                .filter(m -> m.getParentId() == null || m.getParentId() == 0L)
                .collect(Collectors.toList());
    }
}
