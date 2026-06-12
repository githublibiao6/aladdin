package com.aladdin.system.service;

import com.aladdin.common.db.base.BaseService;
import com.aladdin.system.entity.SysResource;

import java.util.List;

/**
 * 系统资源服务接口
 *
 * @author cles
 * @date 2026/06/11
 */
public interface SysResourceService extends BaseService<SysResource> {

    List<SysResource> getResourceTree();

    List<SysResource> getResourcesByUserId(Long userId);

    List<SysResource> getResourcesByRoleId(Long roleId);

    List<SysResource> buildResourceTree(List<SysResource> resources);
}
