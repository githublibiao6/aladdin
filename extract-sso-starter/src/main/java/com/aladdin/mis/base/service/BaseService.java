package com.aladdin.mis.base.service;

import com.aladdin.mis.base.mapper.BaseMapper;
import com.aladdin.mis.base.model.BaseModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;

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
public interface BaseService<M extends BaseMapper<T>, T extends BaseModel> {

    int insert(T entity);

    int deleteById(Serializable id);

    int deleteById(T entity);

    int deleteBatchIds(@Param("coll") Collection<?> idList);

    int updateById(@Param("et") T entity);

    T selectById(Serializable id);

    List<T> selectBatchIds(@Param("coll") Collection<? extends Serializable> idList);

}
