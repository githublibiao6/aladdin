package com.apps.omnipotent.system.global.service;

import com.apps.omnipotent.system.core.BaseModel;
import com.apps.omnipotent.system.pagehelper.entity.PageEntity;

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
public interface GlobalService<T> {

    /**
     *
     * 插入实体
     * @param id 实体
     * @param clazz 所需class
     * @return model
     */
    <T> T detailQuery(String id, Class<T> clazz);

    /**
     * 插入实体
     * @param model) 实体
     * @return model
     */
    BaseModel insertSelective(BaseModel model);

    /**
     * 插入实体
     * @param model 实体
     * @return model
     */
    BaseModel updateSelective(BaseModel model);
    /**
     * 更新实体
     * @param primaryKey) 实体
     * @return model
     */
    boolean deleteById(String primaryKey);

    /**
     * 删除
     * @param model) 实体
     * @return
     */
    boolean delete(BaseModel model);
}
