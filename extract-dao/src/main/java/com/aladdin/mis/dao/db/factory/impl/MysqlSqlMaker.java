package com.aladdin.mis.dao.db.factory.impl;
/*
 * Created by cles on 2020/5/31 21:42
 */

import com.aladdin.mis.dao.db.factory.BaseSqlMaker;
import com.aladdin.mis.system.db.entity.TableFieldInfo;
import com.alibaba.fastjson.JSONObject;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @description:
 * @author cles
 * @Date 2020/5/31 21:42
 */
public class MysqlSqlMaker extends BaseSqlMaker {

    /**
     * mysql 关键字
     */
    private String[] keyWords = {"show","enable","type"};

    @Override
    public JSONObject saveSql(String tableName, String primaryKey, List<TableFieldInfo> list) {
        // 设置默认的id
        AtomicReference<String> id = new AtomicReference<>(UUID.randomUUID().toString());
        StringBuilder sql = new StringBuilder("INSERT INTO "+tableName);
        List<TableFieldInfo> columns = new ArrayList<>();
        AtomicReference<String> primaryValue = new AtomicReference<>("");
        list.forEach(t->{
            if(t.getFieldValue() == null){
                return;
            }
            if("id".equals(t.getColumnName()) && t.getFieldValue().toString().trim().isEmpty()){
                return;
            }
            columns.add(t);
        });
        if(columns.size() < 1){
            throw new RuntimeException("model has no value");
        }
        sql.append("(");
        columns.forEach(t->{
            String colName = t.getColName();
            if(containsWorlds(colName)){
                colName = "`"+colName+"`";
            }
            sql.append(colName).append(",");
        });
        sql.deleteCharAt(sql.length()-1);
        sql.append(" ) VALUES (");
        columns.forEach(t->{
            switch (t.getColumnType()){
                case "int":
                case "Integer":
                case "Boolean":
                case "boolean":
                    sql.append(t.getFieldValue()).append(",");
                    break;
                case "String":
                case "List<String>":
                    sql.append("'")
                            .append(t.getFieldValue())
                            .append("'")
                            .append(",");
                    break;
                case "Date":
                    Date date = (Date) t.getFieldValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String value = sdf.format(date);
                    sql.append("'")
                            .append(value)
                            .append("'")
                            .append(",");
                    break;
                case "LocalDate":
                    LocalDate localDate = (LocalDate) t.getFieldValue();
                    DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    String localDates = dtf1.format(localDate);
                    sql.append("'")
                            .append(localDates)
                            .append("'")
                            .append(",");
                    break;
                case "LocalDateTime":
                    LocalDateTime dateTime = (LocalDateTime) t.getFieldValue();
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    String dateTimes = dtf.format(dateTime);
                    sql.append("'")
                            .append(dateTimes)
                            .append("'")
                            .append(",");
                    break;
                default:
                    sql.append("'',");
                    break;
            }
        });
        sql.deleteCharAt(sql.length()-1);
        sql.append(")");
        JSONObject obj = new JSONObject();
        obj.put("sql",sql.toString());
        obj.put("id",id.get());
        return obj;
    }

    @Override
    public String updateSql(String tableName, String primaryKey, List<TableFieldInfo> list) {
//        UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
        StringBuilder sql = new StringBuilder("UPDATE "+tableName +" SET ");
        List<TableFieldInfo> columns = new ArrayList<>();
        AtomicReference<Object> primaryValue = new AtomicReference<>("");
        list.forEach(t->{
            if(primaryKey.equals(t.getColumnName())){
                primaryValue.set(t.getFieldValue());
            }else if(t.getFieldValue() != null){
                columns.add(t);
            }
        });
        if(primaryValue.get() == null){
            throw new RuntimeException("update must has primary key");
        }
        columns.forEach(t->{
            String colName = t.getColName();
            if(containsWorlds(colName)){
                colName = "`"+colName+"`";
            }
            if(t.getColumnType() == null) {
                System.err.println(t.getColumnName());
            }
            switch (t.getColumnType()){
                case "int":
                case "Integer":
                case "Boolean":
                case "boolean":
                    sql.append(colName).append("=")
                            .append(t.getFieldValue()).append(",");
                    break;
                case "String":
                    sql.append(colName).append("=").append("'")
                            .append(t.getFieldValue()).append("'").append(",");
                    break;
                case "Date":
                    sql.append(colName).append("=");
                    Date date = (Date) t.getFieldValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String value = sdf.format(date);
                    sql.append("'")
                            .append(value)
                            .append("'")
                            .append(",");
                    break;
                case "LocalDateTime":
                    sql.append(colName).append("=");
                    LocalDateTime localDateTime = (LocalDateTime) t.getFieldValue();
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    String localDateTimeValue = dtf.format(localDateTime);
                    sql.append("'")
                            .append(localDateTimeValue)
                            .append("'")
                            .append(",");
                    break;
                case "LocalDate":
                    sql.append(colName).append("=");
                    LocalDate localDate = (LocalDate) t.getFieldValue();
                    DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    String  localDateValue = dtf2.format(localDate);
                    sql.append("'")
                            .append(localDateValue)
                            .append("'")
                            .append(",");
                    break;
                default:
                    break;
            }
        });
        sql.append(" sys007=sys007+1");
        sql.append(" WHERE ").append(primaryKey).append(" = '").append(primaryValue.get()).append("'");
        return sql.toString();
    }

    private boolean containsWorlds(String colName){
        for (String keyWord : keyWords) {
            if (keyWord.equalsIgnoreCase(colName)) {
                return true;
            }
        }
        return false;
    }
}
