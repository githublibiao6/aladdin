package com.aladdin.mis.base.mapper;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BaseMapper<T> extends Mapper<T> {

    @Update("")
    int insert(T entity);

    @Update("")
    int deleteById(Serializable id);

    @Update("")
    int deleteById(T entity);

    @Update("")
    int deleteBatchIds(@Param("coll") Collection<?> idList);

    @Update("")
    int updateById(@Param("et") T entity);

    @Select("")
    T selectById(Serializable id);

    @Select("")
    List<T> selectBatchIds(@Param("coll") Collection<? extends Serializable> idList);
}

