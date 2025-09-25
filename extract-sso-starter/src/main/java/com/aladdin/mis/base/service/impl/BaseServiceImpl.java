package com.aladdin.mis.base.service.impl;

import com.aladdin.mis.base.mapper.BaseMapper;
import com.aladdin.mis.base.model.BaseModel;
import com.aladdin.mis.base.service.BaseService;
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
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseModel> implements BaseService<M, T> {


    @Override
    public int insert(T entity) {
        return 0;
    }

    @Override
    public int deleteById(Serializable id) {
        return 0;
    }

    @Override
    public int deleteById(T entity) {
        return 0;
    }

    @Override
    public int deleteBatchIds(Collection<?> idList) {
        return 0;
    }

    @Override
    public int updateById(T entity) {
        return 0;
    }

    @Override
    public T selectById(Serializable id) {
        return null;
    }

    @Override
    public List<T> selectBatchIds(Collection<? extends Serializable> idList) {
        return List.of();
    }
}
