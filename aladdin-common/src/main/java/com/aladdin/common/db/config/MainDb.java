package com.aladdin.common.db.config;

import com.aladdin.common.db.bean.TableFieldInfo;
import com.aladdin.common.db.bean.TableInfo;
import com.aladdin.common.db.core.DbTableInfo;
import com.aladdin.common.db.factory.DbMaker;
import com.aladdin.common.core.utils.StringUtil;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主数据源配置
 *
 * @author cles
 * @date 2026/04/30
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@Component
public class MainDb {

    private static Map<String, TableInfo> map = new HashMap<>();
    private String url;
    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Bean(name = "main_db")
    public DruidDataSource dataSource() {
        DbConfig db = new DbConfig();
        return null;
    }

    public static void init() {
        DbTableInfo dbTableInfo = DbMaker.getDbTableInfo(Db.use().getDbType());
        List<Map<String, Object>> tables = dbTableInfo.listTable();
        List<Map<String, Object>> fields = dbTableInfo.listTableColumns(null);
        tables.forEach(t -> {
            String tableName = t.get("table_name").toString();
            TableInfo tableInfo = new TableInfo();
            tableInfo.setTableName(tableName);
            List<TableFieldInfo> list = new ArrayList<>();
            List<String> pks = new ArrayList<>();
            Map<String, String> colColumn = new HashMap<>();
            Map<String, String> columnCol = new HashMap<>();
            fields.forEach(f -> {
                if (tableName.equals(f.get("table_name"))) {
                    TableFieldInfo field = convertField(f);
                    list.add(field);
                    if (field.isPk()) {
                        pks.add(field.getColumnName());
                    }
                    colColumn.put(field.getColName(), field.getColumnName());
                    columnCol.put(field.getColumnName(), field.getColName());
                }
            });
            tableInfo.setFields(list);
            tableInfo.setColumnCol(columnCol);
            tableInfo.setColColumn(colColumn);
            tableInfo.setPks(pks);
            map.put(tableName, tableInfo);
        });
    }

    public static TableInfo initTableInfo(String tableName) {
        TableInfo tableInfo = new TableInfo();
        tableInfo.setTableName(tableName);
        DbTableInfo dbTableInfo = DbMaker.getDbTableInfo(Db.use().getDbType());
        Map<String, Object> tableMap = dbTableInfo.listTableInfo(tableName);
        if (tableMap.get("table_comment") != null) {
            tableInfo.setTableComment(tableMap.get("table_comment").toString());
        }
        List<Map<String, Object>> fields = dbTableInfo.listTableColumns(tableName);
        List<TableFieldInfo> list = new ArrayList<>();
        List<String> pks = new ArrayList<>();
        fields.forEach(f -> {
            if (tableName.equals(f.get("table_name"))) {
                TableFieldInfo field = convertField(f);
                list.add(field);
                if (field.isPk()) {
                    pks.add(field.getColumnName());
                }
            }
        });
        tableInfo.setFields(list);
        tableInfo.setPks(pks);
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    private static TableFieldInfo convertField(Map map) {
        TableFieldInfo field = new TableFieldInfo();
        if (map.get("column_name") != null) {
            String colName = map.get("column_name").toString();
            field.setColName(colName);
            field.setColumnName(StringUtil.firstCharLower(StringUtil.toCamelCase(colName)));
        }
        if (map.get("column_comment") != null) {
            field.setColumnComment(map.get("column_comment").toString());
        } else {
            field.setColumnComment(map.get("column_name").toString());
        }
        if (map.get("col_type") != null) {
            field.setColType(map.get("col_type").toString());
            switch (map.get("col_type").toString()) {
                case "text":
                    field.setColumnType("String");
                    break;
                case "varchar":
                    if (field.getColumnComment() != null && field.getColumnComment().endsWith("list")) {
                        field.setColumnType("List<String>");
                    } else {
                        field.setColumnType("String");
                    }
                    break;
                case "int":
                    field.setColumnType("Integer");
                    break;
                case "tinyint":
                    field.setColumnType("Integer");
                    if ("1".equals(map.get("col_length"))) {
                        field.setColumnType("Boolean");
                    }
                    break;
                case "double":
                    field.setColumnType("Double");
                    break;
                case "date":
                    field.setColumnType("LocalDate");
                    break;
                case "timestamp":
                case "datetime":
                    field.setColumnType("LocalDateTime");
                    break;
                case "time":
                    field.setColumnType("LocalTime");
                    break;
                default:
                    break;
            }
        }
        if (map.get("col_length") != null) {
            field.setColLength(Integer.parseInt((String) map.get("col_length")));
        }
        field.setPk(false);
        if (map.get("pk") != null && !org.springframework.util.StringUtils.isEmpty(map.get("pk"))) {
            field.setPk(true);
        }
        return field;
    }

    public static TableInfo getTableInfo(String tableName) {
        return map.get(tableName);
    }

    public static Map<String, TableInfo> getTableMap() {
        return map;
    }
}
