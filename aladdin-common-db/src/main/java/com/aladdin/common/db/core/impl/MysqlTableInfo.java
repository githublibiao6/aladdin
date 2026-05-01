package com.aladdin.common.db.core.impl;

import com.aladdin.common.db.config.Db;
import com.aladdin.common.db.core.DbTableInfo;

import java.util.List;
import java.util.Map;

/**
 * MySQL表信息
 *
 * @author cles
 * @date 2026/04/30
 */
public class MysqlTableInfo implements DbTableInfo {

    @Override
    public List<Map<String, Object>> listTable() {
        String tableSchema = Db.use().getTableSchema();
        return Db.use().baseFind("select table_name, create_time, table_comment, table_rows from information_schema.tables where table_schema='" + tableSchema + "'");
    }

    @Override
    public List<Map<String, Object>> listTableColumns(String tableName) {
        String tableSchema = Db.use().getTableSchema();
        String sql = "SELECT " +
                "table_name," +
                "column_name," +
                "data_type col_type," +
                "CHARACTER_MAXIMUM_LENGTH col_length," +
                "column_type," +
                "column_comment," +
                "column_key pk FROM information_schema.COLUMNS\n" +
                "WHERE TABLE_SCHEMA ='" + tableSchema + "'";
        if (tableName != null) {
            sql += " and table_name = '" + tableName + "'";
        }
        return Db.use().baseFind(sql);
    }

    @Override
    public Map<String, Object> listTableInfo(String tableName) {
        String tableSchema = Db.use().getTableSchema();
        String sql = "SELECT " +
                " table_name," +
                " table_comment " +
                " FROM information_schema.TABLES\n" +
                "WHERE TABLE_SCHEMA ='" + tableSchema + "'";
        if (tableName != null) {
            sql += " and table_name = '" + tableName + "'";
        }
        return Db.use().findFirst(sql);
    }
}
