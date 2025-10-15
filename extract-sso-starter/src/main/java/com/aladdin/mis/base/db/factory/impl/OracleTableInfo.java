package com.aladdin.mis.base.db.factory.impl;
/**
 * Created by cles on 2025/6/4 23:14
 */


import com.aladdin.mis.base.db.factory.DbTableFactory;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author cles
 * @Date 2025/6/4 23:14
 */
public class OracleTableInfo  implements DbTableFactory {

    @Override
    public List<Map<String, Object>> listTable(String tableSchema) {
        return null;
    }

    @Override
    public List<Map<String, Object>> listTableColumns(String tableSchema, String tableName) {
        return null;
    }

    @Override
    public Map<String, Object> listTableInfo(String tableSchema, String tableName) {
        return null;
    }
}
