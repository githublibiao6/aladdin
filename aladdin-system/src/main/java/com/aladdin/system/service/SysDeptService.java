package com.aladdin.system.service;

import com.aladdin.common.db.base.BaseService;
import com.aladdin.system.entity.SysDept;

import java.util.List;

/**
 * 系统部门服务接口
 *
 * @author cles
 * @date 2026/05/06
 */
public interface SysDeptService extends BaseService<SysDept> {

    List<SysDept> getDeptTree();

    List<SysDept> buildDeptTree(List<SysDept> depts);
}
