package com.aladdin.common.db.base;

import com.aladdin.common.core.domain.PageQuery;
import com.aladdin.common.core.domain.PageResult;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 基础DAO接口
 *
 * @author cles
 * @date 2026/05/06
 */
public interface BaseDao<T> {

    T selectById(Serializable id);

    List<T> selectList(T entity);

    int insert(T entity);

    int updateById(T entity);

    int deleteById(Serializable id);

    int deleteBatchIds(Collection<? extends Serializable> ids);

    int selectCount(T entity);

    PageResult<T> selectPage(T entity, PageQuery pageQuery);
}
