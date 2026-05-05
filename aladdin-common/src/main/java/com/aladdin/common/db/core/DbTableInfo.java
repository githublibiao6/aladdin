package com.aladdin.common.db.core;

import java.util.List;
import java.util.Map;

/**
 * 数据库表信息接口
 *
 * @author cles
 * @date 2026/04/30
 */
public interface DbTableInfo {

    List<Map<String, Object>> listTable();

    List<Map<String, Object>> listTableColumns(String tableName);

    Map<String, Object> listTableInfo(String tableName);
}
