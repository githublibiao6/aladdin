package com.apps.omnipotent.system.db.factory;
/*
  Created by cles on 2020/5/31 21:41
 */

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @description: sql语句制造机
 * @author cles
 * @Date 2020/5/31 21:41
 */
public abstract class BaseSqlMaker {

    /**
     * 功能描述：
     *  < 删除数据的语句 >
     * @Description: deleteSql
     * @Author: cles
     * @Date: 2020/6/18 23:59
     * @param tableName 表名
     * @param primaryKey 主键字段
     * @param id 主键值
     * @return: java.lang.String
     * @version: 1.0.0
     */
    public String deleteSql(String tableName,String primaryKey, String id){
        return "update "+tableName+"  set sys005 = '0' where "+primaryKey+"='"+id+"'";
    }

    /**
     * 功能描述：
     *  < 保存实体类的sql语句 >
     * @Description: saveSql
     * @Author: cles
     * @Date: 2020/6/18 23:58
     * @param tableName 表名
     * @param primaryKey 主键字段
     * @param list 字段
     * @return: java.lang.String
     * @version: 1.0.0
     */
    public abstract JSONObject saveSql(String tableName,String primaryKey, List<JSONObject> list);

    /**
     * 功能描述：
     *  < 保存实体类的sql语句 >
     * @Description: updateSql
     * @Author: cles
     * @Date: 2020/6/18 23:59
     * @param tableName 表名
     * @param primaryKey 主键字段
     * @param list 字段
     * @return: java.lang.String
     * @version: 1.0.0
     */
    public abstract String updateSql(String tableName,String primaryKey, List<JSONObject> list);
}
