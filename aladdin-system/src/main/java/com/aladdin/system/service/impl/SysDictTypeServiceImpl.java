package com.aladdin.system.service.impl;

import com.aladdin.common.core.domain.PageQuery;
import com.aladdin.common.core.domain.PageResult;
import com.aladdin.common.db.base.BaseServiceImpl;
import com.aladdin.system.dao.SysDictTypeDao;
import com.aladdin.system.entity.SysDictType;
import com.aladdin.system.service.SysDictTypeService;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.aladdin.system.entity.table.SysDictTypeTableDef.SYS_DICT_TYPE;

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

    @Override
    public PageResult<SysDictType> listPage(PageQuery pageQuery, String dictName, Integer status) {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .where(SYS_DICT_TYPE.SYS005.eq(1));
        if (dictName != null && !dictName.isEmpty()) {
            queryWrapper.and(SYS_DICT_TYPE.DICT_NAME.like(dictName));
        }
        if (status != null) {
            queryWrapper.and(SYS_DICT_TYPE.STATUS.eq(status));
        }
        queryWrapper.orderBy(SYS_DICT_TYPE.SYS001, false);
        com.mybatisflex.core.paginate.Page<SysDictType> page = getMapper()
                .paginate(pageQuery.getPage(), pageQuery.getLimit(), queryWrapper);
        return new PageResult<>(page.getPageNumber(), page.getPageSize(), page.getTotalRow(), page.getRecords());
    }
}
