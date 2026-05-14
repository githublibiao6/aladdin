package com.aladdin.common.db.base;

import com.mybatisflex.core.service.IService;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface BaseService<T> extends IService<T> {

    List<T> list(T entity);

    long count(T entity);

    boolean removeBatchByIds(Collection<? extends Serializable> ids);
}
