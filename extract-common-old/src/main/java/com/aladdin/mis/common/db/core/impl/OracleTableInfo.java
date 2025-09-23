package com.aladdin.mis.common.db.core.impl;
/**
 * Created by cles on 2020/6/4 23:14
 */

import com.aladdin.mis.common.db.core.DbTableInfo;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author cles
 * @Date 2020/6/4 23:14
 */
public class OracleTableInfo  implements DbTableInfo {

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
