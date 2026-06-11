package com.aladdin.system.service.impl;

import com.aladdin.common.db.base.BaseServiceImpl;
import com.aladdin.system.dao.SysDictDataDao;
import com.aladdin.system.entity.SysDictData;
import com.aladdin.system.service.SysDictDataService;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.aladdin.system.entity.table.SysDictDataTableDef.SYS_DICT_DATA;

/**
 * 系统字典数据服务实现
 *
 * @author cles
 * @date 2026/05/06
 */
@Service
public class SysDictDataServiceImpl extends BaseServiceImpl<SysDictDataDao, SysDictData> implements SysDictDataService {

    @Override
    public List<SysDictData> listByDictTypeId(Long dictTypeId) {
        return list(QueryWrapper.create()
                .where(SYS_DICT_DATA.DICT_TYPE_ID.eq(dictTypeId))
                .and(SYS_DICT_DATA.SYS005.eq(1))
                .orderBy(SYS_DICT_DATA.SORT, true));
    }

    @Override
    public List<SysDictData> listByDictType(String dictType) {
        return getMapper().selectByDictType(dictType);
    }
}
