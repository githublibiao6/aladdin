package com.aladdin.mis.base.db.factory.impl;
/**
 * Created by cles on 2025/5/31 21:42
 */

import com.aladdin.mis.base.db.bean.TableFieldInfo;
import com.aladdin.mis.base.db.factory.BaseSqlMaker;
import com.alibaba.fastjson2.JSONObject;

import java.util.List;

/**
 * @description:
 * @author cles
 * @Date 2025/5/31 21:42
 */
public class OracleSqlMaker extends BaseSqlMaker {

    @Override
    public String saveSql(String tableName, String primaryKey, List<TableFieldInfo> list) {
        return null;
    }

    @Override
    public String updateSql(String tableName, String primaryKey, List<TableFieldInfo> list) {
        return null;
    }
}
