package com.aladdin.mis.omnipotent.system.db.factory.impl;
/**
 * Created by cles on 2020/5/31 21:42
 */

import com.aladdin.mis.omnipotent.system.db.factory.BaseSqlMaker;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @description:
 * @author cles
 * @Date 2020/5/31 21:42
 */
public class OracleSqlMaker extends BaseSqlMaker {

    @Override
    public JSONObject saveSql(String tableName, String primaryKey, List<JSONObject> list) {
        return null;
    }

    @Override
    public String updateSql(String tableName, String primaryKey, List<JSONObject> list) {
        return null;
    }
}
