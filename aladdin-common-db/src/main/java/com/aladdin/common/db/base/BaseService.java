package com.aladdin.common.db.base;

import com.aladdin.common.core.domain.PageQuery;
import com.aladdin.common.core.domain.PageResult;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 基础Service接口
 *
 * @author cles
 * @date 2026/05/06
 */
public interface BaseService<T> {

    T getById(Serializable id);

    List<T> list(T entity);

    boolean save(T entity);

    boolean updateById(T entity);

    boolean removeById(Serializable id);

    boolean removeBatchByIds(Collection<? extends Serializable> ids);

    long count(T entity);

    PageResult<T> page(T entity, PageQuery pageQuery);
}
