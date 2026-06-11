package com.aladdin.system.service;

import com.aladdin.common.db.base.BaseService;
import com.aladdin.system.entity.SysDictType;

import java.util.List;

/**
 * 系统字典类型服务接口
 *
 * @author cles
 * @date 2026/05/06
 */
public interface SysDictTypeService extends BaseService<SysDictType> {

    SysDictType getByDictType(String dictType);

    List<SysDictType> listAll();
}
