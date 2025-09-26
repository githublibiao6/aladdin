package com.aladdin.mis.base.mapper;


import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface BaseMapper<T> extends Mapper<T> {

    int insert(T entity);

    int deleteById(Serializable id);

    int deleteById(T entity);

    int deleteBatchIds(@Param("coll") Collection<?> idList);

    int updateById(@Param("et") T entity);

    T selectById(Serializable id);

    List<T> selectBatchIds(@Param("coll") Collection<? extends Serializable> idList);
}

