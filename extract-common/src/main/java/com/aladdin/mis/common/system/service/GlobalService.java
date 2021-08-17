package com.aladdin.mis.common.system.service;

import com.aladdin.mis.system.base.BaseModel;

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
     * @return model
     */
    <T> T detailQuery(Integer id);

    /**
     * 插入实体
     * @param model 实体
     * @return model
     */
    <T> T insertSelective(BaseModel model);

    /**
     * 插入实体
     * @param model 实体
     * @return model
     */
    boolean updateSelective(BaseModel model);
    /**
     * 更新实体
     * @param primaryKey) 实体
     * @return model
     */
    boolean deleteById(Integer primaryKey);

    /**
     * 删除
     * @param model) 实体
     * @return
     */
    boolean delete(BaseModel model);
}
