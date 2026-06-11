package com.aladdin.system.service.impl;

import com.aladdin.common.db.base.BaseServiceImpl;
import com.aladdin.system.dao.SysDeptDao;
import com.aladdin.system.entity.SysDept;
import com.aladdin.system.service.SysDeptService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 系统部门服务实现
 *
 * @author cles
 * @date 2026/05/06
 */
@Service
public class SysDeptServiceImpl extends BaseServiceImpl<SysDeptDao, SysDept> implements SysDeptService {

    @Override
    public List<SysDept> getDeptTree() {
        List<SysDept> allDepts = list();
        return buildDeptTree(allDepts);
    }

    @Override
    public List<SysDept> buildDeptTree(List<SysDept> depts) {
        Map<Long, List<SysDept>> grouped = depts.stream()
                .collect(Collectors.groupingBy(SysDept::getParentId));
        depts.forEach(d -> d.setChildren(grouped.getOrDefault(d.getId(), new ArrayList<>())));
        return depts.stream()
                .filter(d -> d.getParentId() == null || d.getParentId() == 0L)
                .collect(Collectors.toList());
    }
}
