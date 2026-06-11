package com.aladdin.system.service.impl;

import com.aladdin.common.db.base.BaseServiceImpl;
import com.aladdin.system.dao.SysDictTypeDao;
import com.aladdin.system.entity.SysDictType;
import com.aladdin.system.service.SysDictTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统字典类型服务实现
 *
 * @author cles
 * @date 2026/05/06
 */
@Service
public class SysDictTypeServiceImpl extends BaseServiceImpl<SysDictTypeDao, SysDictType> implements SysDictTypeService {

    @Override
    public SysDictType getByDictType(String dictType) {
        return getMapper().selectByDictType(dictType);
    }

    @Override
    public List<SysDictType> listAll() {
        return list();
    }
}
