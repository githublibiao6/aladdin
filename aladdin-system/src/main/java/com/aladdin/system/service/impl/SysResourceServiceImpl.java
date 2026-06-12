package com.aladdin.system.service.impl;

import com.aladdin.common.db.base.BaseServiceImpl;
import com.aladdin.system.dao.SysResourceDao;
import com.aladdin.system.entity.SysResource;
import com.aladdin.system.service.SysResourceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 系统资源服务实现
 *
 * @author cles
 * @date 2026/06/11
 */
@Service
public class SysResourceServiceImpl extends BaseServiceImpl<SysResourceDao, SysResource> implements SysResourceService {

    @Override
    public List<SysResource> getResourceTree() {
        List<SysResource> allResources = list();
        return buildResourceTree(allResources);
    }

    @Override
    public List<SysResource> getResourcesByUserId(Long userId) {
        List<SysResource> resources = getMapper().selectResourcesByUserId(userId);
        return buildResourceTree(resources);
    }

    @Override
    public List<SysResource> getResourcesByRoleId(Long roleId) {
        return getMapper().selectResourcesByRoleId(roleId);
    }

    @Override
    public List<SysResource> buildResourceTree(List<SysResource> resources) {
        Map<Long, List<SysResource>> grouped = resources.stream()
                .collect(Collectors.groupingBy(SysResource::getParentId));
        resources.forEach(r -> r.setChildren(grouped.getOrDefault(r.getId(), new ArrayList<>())));
        return resources.stream()
                .filter(r -> r.getParentId() == null || r.getParentId() == 0L)
                .collect(Collectors.toList());
    }
}
