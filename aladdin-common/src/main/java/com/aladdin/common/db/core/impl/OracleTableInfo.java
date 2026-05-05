package com.aladdin.common.db.core.impl;

import com.aladdin.common.db.core.DbTableInfo;

import java.util.List;
import java.util.Map;

/**
 * Oracle表信息
 *
 * @author cles
 * @date 2026/04/30
 */
public class OracleTableInfo implements DbTableInfo {

    @Override
    public List<Map<String, Object>> listTable() {
        return null;
    }

    @Override
    public List<Map<String, Object>> listTableColumns(String tableName) {
        return null;
    }

    @Override
    public Map<String, Object> listTableInfo(String tableName) {
        return null;
    }
}
