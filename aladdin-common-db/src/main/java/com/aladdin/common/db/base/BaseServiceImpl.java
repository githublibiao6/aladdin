package com.aladdin.common.db.base;

import com.mybatisflex.spring.service.impl.ServiceImpl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class BaseServiceImpl<D extends com.mybatisflex.core.BaseMapper<T>, T> extends ServiceImpl<D, T> implements BaseService<T> {

    @Override
    public List<T> list(T entity) {
        return list();
    }

    @Override
    public long count(T entity) {
        return count();
    }

    @Override
    public boolean removeBatchByIds(Collection<? extends Serializable> ids) {
        return removeByIds(ids);
    }
}
