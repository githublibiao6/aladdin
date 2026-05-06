package com.aladdin.common.db.base;

import com.aladdin.common.core.domain.PageQuery;
import com.aladdin.common.core.domain.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 基础Service实现类
 *
 * @author cles
 * @date 2026/05/06
 */
public class BaseServiceImpl<D extends BaseDao<T>, T> implements BaseService<T> {

    @Autowired
    protected D dao;

    @Override
    public T getById(Serializable id) {
        return dao.selectById(id);
    }

    @Override
    public List<T> list(T entity) {
        return dao.selectList(entity);
    }

    @Override
    public boolean save(T entity) {
        return dao.insert(entity) > 0;
    }

    @Override
    public boolean updateById(T entity) {
        return dao.updateById(entity) > 0;
    }

    @Override
    public boolean removeById(Serializable id) {
        return dao.deleteById(id) > 0;
    }

    @Override
    public boolean removeBatchByIds(Collection<? extends Serializable> ids) {
        return dao.deleteBatchIds(ids) > 0;
    }

    @Override
    public long count(T entity) {
        return dao.selectCount(entity);
    }

    @Override
    public PageResult<T> page(T entity, PageQuery pageQuery) {
        return dao.selectPage(entity, pageQuery);
    }
}
