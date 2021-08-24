package com.aladdin.mis.dao.core;
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
    * @Description: 获取所有的表
    * @Author: cles
     * @Date: 2020/6/4 23:05
     * @return: java.util.List<java.util.Map>
     */
    List<Map> listTable();

    /**
     * 获取表字段
     * @Description: 获取所有的字段
     * @return: java.util.List<java.util.Map>
     * @Author: cles
     * @Date: 2020/6/10 21:22
     * @return
     */
    List<Map> listTableColumns(String tableName);

    Map listTableInfo(String tableName);
}
