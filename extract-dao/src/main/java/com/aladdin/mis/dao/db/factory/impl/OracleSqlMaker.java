package com.aladdin.mis.dao.db.factory.impl;
/**
 * Created by cles on 2020/5/31 21:42
 */

import com.aladdin.mis.dao.db.factory.BaseSqlMaker;
import com.aladdin.mis.common.db.bean.TableFieldInfo;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @description:
 * @author cles
 * @Date 2020/5/31 21:42
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
