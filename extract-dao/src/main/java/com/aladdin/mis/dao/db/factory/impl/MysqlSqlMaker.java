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

    @Override
    public JSONObject saveSql(String tableName, String primaryKey, List<TableFieldInfo> list) {
        // 设置默认的id
        AtomicReference<String> id = new AtomicReference<>(UUID.randomUUID().toString());
        StringBuilder sql = new StringBuilder("INSERT INTO "+tableName);
        List<TableFieldInfo> columns = new ArrayList<>();
        AtomicReference<String> primaryValue = new AtomicReference<>("");
        list.forEach(t->{
//            id 默认为自增的int
//            if(primaryKey.equals(t.getColumnName())){
//                if(t.getFieldValue() != null){
//                    t.put("field_value", id);
//                }else {
//                    id.set(t.getString("field_value"));
//                }
//            }
            if("id".equals(t.getColumnName())){
                return;
            }
            if(t.getFieldValue() != null){
                columns.add(t);
            }
        });
        if(columns.size() < 1){
            throw new RuntimeException("model has no value");
        }
        sql.append("(");
        columns.forEach(t->{

            sql.append(t.getColName()).append(",");
        });
        sql.deleteCharAt(sql.length()-1);
        sql.append(" ) VALUES (");
        columns.forEach(t->{
            switch (t.getColumnType()){
                case "int":
                case "Integer":
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
            if(t.getColumnType() == null)
                System.err.println(t.getColumnName());
            switch (t.getColumnType()){
                case "int":
                case "Integer":
                    sql.append(t.getColName()).append("=")
                            .append(t.getFieldValue()).append(",");
                    break;
                case "String":
                    sql.append(t.getColName()).append("=").append("'")
                            .append(t.getFieldValue()).append("'").append(",");
                    break;
                case "Date":
                    sql.append(t.getColName()).append("=");
                    Date date = (Date) t.getFieldValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String value = sdf.format(date);
                    sql.append("'")
                            .append(value)
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
}
