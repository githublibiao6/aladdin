package com.aladdin.mis.dao.core.impl;
/**
 * Created by cles on 2020/6/4 23:14
 */

import com.aladdin.mis.dao.core.DbTableInfo;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author cles
 * @Date 2020/6/4 23:14
 */
public class OracleTableInfo  implements DbTableInfo {
    @Override
    public List<Map> listTable() {
        return null;
    }

    @Override
    public List<Map> listTableColumns(String tableName) {
        return null;
    }

    @Override
    public Map listTableInfo(String tableName) {
        return null;
    }
}
