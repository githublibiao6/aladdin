package com.aladdin.mis.base.db.factory.impl;

import com.aladdin.mis.base.db.factory.DbTableFactory;
import com.aladdin.mis.base.mapper.DbMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author cles
 * @Date 2025/09/28 23:14
 */
public class MysqlTableInfo implements DbTableFactory {

    @Autowired
    private DbMapper mapper;

    @Override
    public List<Map<String, Object>> listTable(String tableSchema) {
        return mapper.find("select table_name, create_time, table_comment, table_rows from information_schema.tables where table_schema='"+tableSchema+"'");
    }

    @Override
    public List<Map<String, Object>> listTableColumns(String tableSchema, String tableName) {
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
        return mapper.find(sql);
    }

    @Override
    public Map<String, Object> listTableInfo(String tableSchema, String tableName) {
        String sql = "SELECT " +
                " table_name," +
                " table_comment " +
                " FROM information_schema.TABLES\n" +
                "WHERE TABLE_SCHEMA ='"+tableSchema+"'";
        if(tableName != null){
            sql += " and table_name = '"+tableName+"'";
        }
        return mapper.find(sql).get(0);
    }
}
