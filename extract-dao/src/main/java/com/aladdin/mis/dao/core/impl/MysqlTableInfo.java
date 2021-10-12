package com.aladdin.mis.dao.core.impl;
/**
 * Created by cles on 2020/6/4 23:14
 */

import com.aladdin.mis.dao.core.DbTableInfo;
import com.aladdin.mis.dao.utils.Db;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author cles
 * @Date 2020/6/4 23:14
 */
public class MysqlTableInfo implements DbTableInfo {
    @Override
    public List<Map> listTable() {
        String tableSchema = Db.use().getTableSchema();
        return Db.use().find("select table_name, create_time, table_comment, table_rows from information_schema.tables where table_schema='"+tableSchema+"'");
    }

    @Override
    public List<Map> listTableColumns(String tableName) {
        String tableSchema = Db.use().getTableSchema();
        String sql = "SELECT " +
                "table_name," +
                "column_name," +
                "data_type col_type," +
                "CHARACTER_MAXIMUM_LENGTH col_length," +
                "column_type," +
                "column_comment," +
                "column_key pk FROM information_schema.COLUMNS\n" +
                "WHERE TABLE_SCHEMA ='"+tableSchema+"'";
        if(tableName != null){
            sql += " and table_name = '"+tableName+"'";
        }
        return Db.use().find(sql);
    }

    @Override
    public Map listTableInfo(String tableName) {
        String tableSchema = Db.use().getTableSchema();
        String sql = "SELECT " +
                " table_name," +
                " table_comment " +
                " FROM information_schema.TABLES\n" +
                "WHERE TABLE_SCHEMA ='"+tableSchema+"'";
        if(tableName != null){
            sql += " and table_name = '"+tableName+"'";
        }
        return Db.use().findFirst(sql);
    }
}
