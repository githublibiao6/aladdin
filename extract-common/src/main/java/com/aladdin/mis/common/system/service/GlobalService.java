package com.aladdin.mis.common.system.service;

import com.aladdin.mis.base.qo.Condition;
import com.aladdin.mis.system.base.GlobalModel;
import com.github.pagehelper.PageInfo;

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
     * 通用分页
     * @param condition 实体
     * @return model
     */
    <T> PageInfo<T> pageByCondition(Condition condition);

    /**
     * 通用list
     * @param condition
     * @param <T>
     * @return
     */
    <T> List<T> queryByCondition(Condition condition);

    /**
     *
     * 通用详情
     * @param id 实体
     * @return model
     */
    <T> T detailQuery(Integer id);

    /**
     *
     * 通用详情
     * @param id 实体
     * @param clazz
     * @return model
     */
    Object detailQueryVo(Integer id, Class clazz);


    /**
     * 根据条件获取一条数据
     * @param condition
     * @return
     */
    <T> T getByCondition(Condition condition);


    /**
     * 直接插入，返回id
     * @param baseModel model
     * @return int
     */
    Integer insert(GlobalModel baseModel);

    /**
     * 插入实体。返回当前实体
     * @param model 实体
     * @return model
     */
    <T> T insertSelective(GlobalModel model);


    /**
     * 通用更新实体
     * @param model 实体
     * @return model
     */
    boolean updateSelective(GlobalModel model);

    /**
     * 通用更新实体
     * @param model 实体
     * @return model
     */
    <T> T saveOrUpdate(GlobalModel model);

    /**
     * 通用删除
     * @param primaryKey) 实体
     * @return model
     */
    boolean deleteById(Integer primaryKey);

    /**
     * 删除
     * @param model) 实体
     * @return
     */
    boolean delete(GlobalModel model);

}
