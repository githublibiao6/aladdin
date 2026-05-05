package com.aladdin.common.db.factory;

import com.aladdin.common.db.bean.TableFieldInfo;
import com.alibaba.fastjson2.JSONObject;

import java.util.List;

/**
 * SQL语句生成基类
 *
 * @author cles
 * @date 2026/04/30
 */
public abstract class BaseSqlMaker {

    public String deleteSql(String tableName, String primaryKey, Integer id) {
        return "update " + tableName + "  set sys005 = '0'  where " + primaryKey + "= " + id;
    }

    public abstract JSONObject saveSql(String tableName, String primaryKey, List<TableFieldInfo> list);

    public abstract String updateSql(String tableName, String primaryKey, List<TableFieldInfo> list);
}
