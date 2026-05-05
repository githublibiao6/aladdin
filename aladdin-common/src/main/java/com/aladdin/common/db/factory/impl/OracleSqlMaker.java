package com.aladdin.common.db.factory.impl;

import com.aladdin.common.db.bean.TableFieldInfo;
import com.aladdin.common.db.factory.BaseSqlMaker;
import com.alibaba.fastjson2.JSONObject;

import java.util.List;

/**
 * Oracle语句生成器
 *
 * @author cles
 * @date 2026/04/30
 */
public class OracleSqlMaker extends BaseSqlMaker {

    @Override
    public JSONObject saveSql(String tableName, String primaryKey, List<TableFieldInfo> list) {
        return null;
    }

    @Override
    public String updateSql(String tableName, String primaryKey, List<TableFieldInfo> list) {
        return null;
    }
}
