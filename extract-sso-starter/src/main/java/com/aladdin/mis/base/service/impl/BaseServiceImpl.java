package com.aladdin.mis.base.service.impl;

import com.aladdin.mis.base.mapper.BaseMapper;
import com.aladdin.mis.base.model.BaseModel;
import com.aladdin.mis.base.service.BaseService;
import jakarta.annotation.Resource;
import lombok.Getter;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

/**
 * 功能描述：
 *  < 全局service方法 >
 * @Description:
 * @Author: cles
 * @Date: 2025/09/26 23:23
 * @return:
 * @version: 1.0.0
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseModel> implements BaseService<T> {

    @Autowired
    protected M baseMapper;

    @Override
    public boolean insert(T entity) {
        return baseMapper.insert(entity) > 0 ;
    }

    @Override
    public boolean deleteById(Serializable id) {
        return baseMapper.deleteById(id) > 0;
    }

    @Override
    public boolean deleteById(T entity) {
        return baseMapper.deleteById(1) > 0;
    }

    @Override
    public boolean deleteBatchIds(Collection<?> idList) {
        return false;
    }

    @Override
    public boolean updateById(T entity) {
        return baseMapper.updateById(entity) > 0;
    }

    @Override
    public T selectById(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<T> selectBatchIds(Collection<? extends Serializable> idList) {
        return baseMapper.selectBatchIds(idList);
    }
}
