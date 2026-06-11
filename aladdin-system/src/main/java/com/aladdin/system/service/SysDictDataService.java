package com.aladdin.system.service;

import com.aladdin.common.db.base.BaseService;
import com.aladdin.system.entity.SysDictData;

import java.util.List;

/**
 * 系统字典数据服务接口
 *
 * @author cles
 * @date 2026/05/06
 */
public interface SysDictDataService extends BaseService<SysDictData> {

    List<SysDictData> listByDictTypeId(Long dictTypeId);

    List<SysDictData> listByDictType(String dictType);
}
