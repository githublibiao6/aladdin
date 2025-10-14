package com.aladdin.mis.base.mapper;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BaseMapper<T> extends Mapper<T> {

    @Update("insert")
    int insert(T entity);

    @Update("deleteById")
    int deleteById(Serializable id);

    @Update("deleteBatchIds")
    int deleteBatchIds(@Param("coll") Collection<?> idList);

    @Update("updateById")
    int updateById(@Param("et") T entity);

    @Select("selectById")
    T selectById(Serializable id);

    @Select("selectBatchIds")
    List<T> selectBatchIds(@Param("coll") Collection<? extends Serializable> idList);
}

