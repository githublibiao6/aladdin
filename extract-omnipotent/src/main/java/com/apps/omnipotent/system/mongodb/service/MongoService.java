package com.apps.omnipotent.system.mongodb.service;
/*
 *  Created by cles on 2020/12/1 22:44
 */

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * @author cles
 * @description:
 * @Date 2020/12/1 22:44
 * @version: 1.0.0
 */
public interface MongoService<T>{

    /**
     * 保存一个对象
     * @param t
     */
    void save(T t);

    /**
     * 保存一组对象
     * @param t
     */
    void saveList(List<T> t);

    /**
     * 根据对象Id查找该对象
     * @param cls
     * @param id
     * @return
     */
    T queryById(Class<T> cls,String id);

    /**
     * 根据条件查询集合
     * @param cls
     * @param query
     * @return
     */
    List<T> queryList(Class<T> cls, Query query);

    /**
     * 通过条件查询单个实体
     * @param cls
     * @param query
     * @return
     */
    T queryOne(Class<T> cls,Query query);

    /**
     * 分页查询
     * @param cls
     * @param query
     * @param start
     * @param size
     * @return
     */
    List<T> getPage(Class<T> cls,Query query, int start, int size);

    /**
     * 查询符合条件的记录总数
     * @param cls
     * @param query
     * @return
     */
    Long getPageCount(Class<T> cls,Query query);

    /**
     * 根据id删除对象
     * @param cls
     * @param id
     */
    void deleteById(Class<T> cls,String id);

    /**
     * 删除对象
     * @param t
     */
    void delete(T t);

    /**
     * 更新指定id的属性值
     * @param cls
     * @param id
     * @param objName
     * @param objValue
     */
    void updateFirst(Class<T> cls,String id, String objName, String objValue);

    /**
     * 查找更新
     * @param cls
     * @param query
     * @param update
     */
    void updateInser(Class<T> cls,Query query, Update update);

}