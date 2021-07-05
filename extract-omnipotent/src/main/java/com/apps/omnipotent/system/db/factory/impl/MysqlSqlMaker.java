package com.apps.omnipotent.system.db.factory.impl;
/*
 * Created by cles on 2020/5/31 21:42
 */

import com.alibaba.fastjson.JSONObject;
import com.apps.omnipotent.system.db.factory.BaseSqlMaker;
import com.apps.omnipotent.system.utils.StringUtil;

import java.text.SimpleDateFormat;
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
    public JSONObject saveSql(String tableName, String primaryKey, List<JSONObject> list) {
        // 设置默认的id
        AtomicReference<String> id = new AtomicReference<>(UUID.randomUUID().toString());
        StringBuilder sql = new StringBuilder("INSERT INTO "+tableName);
        List<JSONObject> columns = new ArrayList<>();
        AtomicReference<String> primaryValue = new AtomicReference<>("");
        list.forEach(t->{
            if(primaryKey.equals(t.getString("table_field"))){
                if(StringUtil.isBlank(t.getString("field_value"))){
                    t.put("field_value", id);
                }else {
                    id.set(t.getString("field_value"));
                }
            }
            if(t.get("field_value") != null){
                columns.add(t);
            }
        });
        if(columns.size() < 1){
            throw new RuntimeException("model has no value");
        }
        sql.append("(");
        columns.forEach(t->{

            sql.append(t.getString("table_field")).append(",");
        });
        sql.deleteCharAt(sql.length()-1);
        sql.append(" ) VALUES (");
        columns.forEach(t->{
            switch (t.getString("field_type")){
                case "int":
                    sql.append(t.getIntValue("field_value")).append(",");
                    break;
                case "String":
                    sql.append("'")
                            .append(t.getString("field_value"))
                            .append("'")
                            .append(",");
                    break;
                case "Date":
                    Date date = t.getDate("field_value");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String value = sdf.format(date);
                    sql.append("'")
                            .append(value)
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
    public String updateSql(String tableName, String primaryKey, List<JSONObject> list) {
//        UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
        StringBuilder sql = new StringBuilder("UPDATE "+tableName +" SET ");
        List<JSONObject> columns = new ArrayList<>();
        AtomicReference<String> primaryValue = new AtomicReference<>("");
        list.forEach(t->{
            if(primaryKey.equals(t.getString("table_field"))){
                primaryValue.set(t.getString("field_value"));
            }else if(t.get("field_value") != null){
                columns.add(t);
            }
        });
        if(StringUtil.isBlank(primaryValue.get())){
            throw new RuntimeException("update must has primary key");
        }
        columns.forEach(t->{
            switch (t.getString("field_type")){
                case "int":
                    sql.append(t.getString("table_field")).append("=")
                            .append(t.getIntValue("field_value")).append(",");
                    break;
                case "String":
                    sql.append(t.getString("table_field")).append("=").append("'")
                            .append(t.getString("field_value")).append("'").append(",");
                    break;
                case "Date":
                    sql.append(t.getString("table_field")).append("=");
                    Date date = t.getDate("field_value");
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
