package com.aladdin.mis.base.mapper;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface BaseMapper<T> extends Mapper<T> {

    int insert(T entity);

    int deleteById(Serializable id);

    int deleteById(T entity);

    int deleteBatchIds(@Param("coll") Collection<?> idList);

    @Update("")
    int updateById(@Param("et") T entity);

    T selectById(Serializable id);

    List<T> selectBatchIds(@Param("coll") Collection<? extends Serializable> idList);
}

