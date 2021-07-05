package com.apps.omnipotent.system.db.config;
/**
 * Created by cles on 2020/5/31 18:29
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.apps.omnipotent.manager.bean.Menu;
import com.apps.omnipotent.system.core.DbTableInfo;
import com.apps.omnipotent.system.core.Table;
import com.apps.omnipotent.system.core.TableField;
import com.apps.omnipotent.system.db.bean.TableFieldInfo;
import com.apps.omnipotent.system.db.bean.TableInfo;
import com.apps.omnipotent.system.db.factory.DbMaker;
import com.apps.omnipotent.system.db.utils.Db;
import com.apps.omnipotent.system.utils.StringUtil;
import org.reflections.Reflections;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @description: 默认数据源加入DB
 * @author cles
 * @Date 2020/5/31 18:29
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class MainDb {

    private static Map<String , TableInfo> map = new HashMap<>();
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

    /**
     *  application.properteis中对应属性的前缀
     */
    @Bean(name = "main_db")
    public void dataSource() {
        DbConfig db = new DbConfig();
        DruidDataSource druidDataSource = db.buildDataSource(url,username,password,null);
        Db.setMain(druidDataSource);
    }

    /**
     * 功能描述：
     *  < 初始化主数据源的表 >
     * @Description: init
     * @Author: cles
     * @Date: 2020/6/18 22:37
     * @return: void
     * @version: 1.0.0
     */
    public static void init(){
        DbTableInfo dbTableInfo = DbMaker.getDbTableInfo(Db.use().getDbType());
        List<Map> tables = dbTableInfo.listTable();
        List<Map> fields = dbTableInfo.listTableColumns();
        tables.forEach(t->{
            String tableName = t.get("table_name").toString();
            TableInfo tableInfo = new TableInfo();
            tableInfo.setTableName(tableName);
            List<TableFieldInfo> list = new ArrayList<>();
            List<String> pks = new ArrayList<>();
            fields.forEach(f->{
                if(tableName.equals(f.get("table_name"))){
                    TableFieldInfo field = convertField(f);
                    list.add(field);
                    if(field.isPk()){
                        pks.add(field.getColumnName());
                    }
                }
            });
            tableInfo.setFields(list);
            tableInfo.setPks(pks);
            map.put(tableName,tableInfo);
        });
        getRequestMappingMethod("com.apps.omnipotent");
    }

    /**
     * 功能描述：
     *  < 将字段map转为字段实体>
     * @Description: convertField
     * @Author: cles
     * @Date: 2020/6/18 22:39
     * @param map 参数1
     * @return: com.apps.omnipotent.system.db.bean.TableFieldInfo
     * @version: 1.0.0
     */
    private static TableFieldInfo convertField(Map map){
        TableFieldInfo field = new TableFieldInfo();
        if(map.get("column_name") != null){
            field.setColumnName(map.get("column_name").toString());
        }
        if(map.get("col_type") != null){
            field.setColType(map.get("col_type").toString());
        }
        if(map.get("col_length") != null){
            field.setColLength(map.get("col_length").toString());
        }
        field.setPk(false);
        if(map.get("pk") != null && StringUtil.notBlank(map.get("pk").toString())){
            field.setPk(true);
        }
        return field;
    }

    /**
     * 将对应的类和数据库对应
     * @param packageName 实体类对应包名称
     */
    private static void getRequestMappingMethod(String packageName) {
        Reflections reflections = new Reflections(packageName);
        Set<Class<?>> classesList = reflections.getTypesAnnotatedWith(Table.class);

        for (Class clazz : classesList) {
            List<Field> fieldList = new ArrayList<>();
            Table table = (Table) clazz.getAnnotation(Table.class);
            String tableName = table.value();
            TableInfo tableInfo = map.get(tableName);
            List<TableFieldInfo> list = tableInfo.getFields();
            Field[] fields  = clazz.getDeclaredFields();
            Class parentClazz = clazz.getSuperclass();
            Field[] parentFields  = parentClazz.getDeclaredFields();
            fieldList.addAll(Arrays.asList(fields));
            fieldList.addAll(Arrays.asList(parentFields));
            for (Field field : fieldList) {
                String fieldName = field.getName();
                boolean tableFieldExists = field.isAnnotationPresent(TableField.class);
                if(tableFieldExists){
                    TableField tableField = field.getDeclaredAnnotation(TableField.class);
                    fieldName = tableField.value();
                }
                String finalFieldName = fieldName;
                list.forEach(t->{
                    if(finalFieldName.equals(t.getColumnName())){
                        t.setFieldName(field.getName());
                    }
                });
            }
        }
    }

    /**
    * @Description: 获取主数据源表信息
    * @Param: [tableName]
    * @return: com.apps.omnipotent.system.db.bean.TableInfo
    * @Author: cles
    * @Date: 2020/6/9 23:34
    */
    public static TableInfo getTableInfo(String tableName){
        return map.get(tableName);
    }

    public static Map<String, TableInfo> getTableMap(){
        return map;
    }
}
