package com.aladdin.mis.common.db.core;
/**
 * Created by cles on 2020/6/4 23:04
 */

import java.util.List;
import java.util.Map;

/**
 * @description:  初始化接口
 * @author cles
 * @Date 2020/6/4 23:04
 */
public interface DbTableInfo {

    /**
     * 获取所有的表
     * @Author: cles
     * @Date: 2020/6/4 23:05
     * @return: java.util.List<java.util.Map>
     */
    List<Map<String, Object>> listTable();

    /**
     * 获取所有的字段
     * @param tableName 表名
     * @return
     */
    List<Map<String, Object>> listTableColumns(String tableName);

    /**
     * 获取表信息
     * @param tableName 表名
     * @return
     */
    Map<String, Object> listTableInfo(String tableName);
}
