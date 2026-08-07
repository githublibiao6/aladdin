package com.aladdin.system.service;

import com.aladdin.common.core.domain.PageQuery;
import com.aladdin.common.core.domain.PageResult;
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

    /**
     * 分页查询字典类型
     *
     * @param pageQuery 分页参数
     * @param dictName  字典名称(模糊匹配，可为空)
     * @param status    状态(可为空)
     */
    PageResult<SysDictType> listPage(PageQuery pageQuery, String dictName, Integer status);
}
