package com.apps.omnipotent.system.core.impl;
/**
 * Created by cles on 2020/6/4 23:14
 */

import com.apps.omnipotent.system.core.DbTableInfo;
import com.apps.omnipotent.system.db.utils.Db;

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
        return Db.use().find("select table_name from information_schema.tables where table_schema='"+tableSchema+"'");
    }

    @Override
    public List<Map> listTableColumns() {
        String tableSchema = Db.use().getTableSchema();
        return Db.use().find("SELECT " +
                "table_name,column_name," +
                "data_type col_type," +
                "CHARACTER_MAXIMUM_LENGTH col_length," +
                "column_type," +
                "column_key pk FROM information_schema.COLUMNS\n" +
                "WHERE TABLE_SCHEMA ='"+tableSchema+"'");
    }
}
