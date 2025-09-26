package com.aladdin.mis.base.service;

import com.aladdin.mis.base.mapper.BaseMapper;
import com.aladdin.mis.base.model.BaseModel;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 功能描述：
 *  < 全局service方法 >
 * @Description:
 * @Author: cles
 * @Date: 2020/6/23 23:23
 * @return:
 * @version: 1.0.0
 */
public interface BaseService<T extends BaseModel> {

    boolean insert(T entity);

    boolean deleteById(Serializable id);

    boolean deleteById(T entity);

    boolean deleteBatchIds(@Param("coll") Collection<?> idList);

    boolean updateById(@Param("et") T entity);

    T selectById(Serializable id);

    List<T> selectBatchIds(@Param("coll") Collection<? extends Serializable> idList);

}
