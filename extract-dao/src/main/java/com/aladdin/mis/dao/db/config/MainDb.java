package com.aladdin.mis.dao.db.config;
/**
 * Created by cles on 2020/5/31 18:29
 */

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.dao.core.DbTableInfo;
import com.aladdin.mis.dao.db.factory.DbMaker;
import com.aladdin.mis.dao.utils.Db;
import com.aladdin.mis.system.db.entity.TableFieldInfo;
import com.aladdin.mis.system.db.entity.TableInfo;
import com.alibaba.druid.pool.DruidDataSource;
import org.reflections.Reflections;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @description: 默认数据源加入DB
 * @author cles
 * @Date 2020/5/31 18:29
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@Component
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
        List<Map> fields = dbTableInfo.listTableColumns(null);
        tables.forEach(t->{
            String tableName = t.get("table_name").toString();
            TableInfo tableInfo = new TableInfo();
            tableInfo.setTableName(tableName);
            List<TableFieldInfo> list = new ArrayList<>();
            List<String> pks = new ArrayList<>();
            Map<String, String> colColumn = new HashMap<>();
            Map<String, String> columnCol = new HashMap<>();
            fields.forEach(f->{
                if(tableName.equals(f.get("table_name"))){
                    TableFieldInfo field = convertField(f);
                    list.add(field);
                    if(field.isPk()){
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
            map.put(tableName,tableInfo);
        });
        getRequestMappingMethod("com.aladdin.mis");
    }

    public static TableInfo  initTableInfo(String tableName){
        TableInfo tableInfo = new TableInfo();

        tableInfo.setTableName(tableName);

        DbTableInfo dbTableInfo = DbMaker.getDbTableInfo(Db.use().getDbType());
        Map tableMap = dbTableInfo.listTableInfo(tableName);
        if(tableMap.get("table_comment") != null){
            tableInfo.setTableComment(tableMap.get("table_comment").toString());
        }
        List<Map> fields = dbTableInfo.listTableColumns(tableName);
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
        return tableInfo;
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
            String colName = map.get("column_name").toString();
            field.setColName(colName);
            field.setColumnName(firstCharLower(toCamelCase(colName)));
        }
        if(map.get("column_comment") != null){
            field.setColumnComment(map.get("column_comment").toString());
        }else {
            field.setColumnComment(map.get("column_name").toString());
        }
        if(map.get("col_type") != null){
            field.setColType(map.get("col_type").toString());
            switch (map.get("col_type").toString()){
                case "text":
                    field.setColumnType("String");
                    break;
                case "varchar":
                    if(field.getColumnComment() != null && field.getColumnComment().endsWith("list")){
                        field.setColumnType("List<String>");
                    }else {
                        field.setColumnType("String");
                    }
                    break;
                case "int":
                    field.setColumnType("Integer");
                    break;
                case "date":
                    field.setColumnType("LocalDate");
                    break;
                case "timestamp":
                case "datetime":
                    field.setColumnType("LocalDateTime");
                    break;
                default:
                    break;
            }
        }
        if(map.get("col_length") != null){
            field.setColLength(map.get("col_length").toString());
        }
        field.setPk(false);
        if(map.get("pk") != null && StringUtils.isEmpty(map.get("pk"))){
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
            if(table == null){
                continue;
            }
            String tableName = table.value();
            TableInfo tableInfo = map.get(tableName);
            if(tableInfo == null){
                continue;
            }
            List<TableFieldInfo> list = tableInfo.getFields();
            Field[] fields  = clazz.getDeclaredFields();
            Class parentClazz = clazz.getSuperclass();
            Field[] parentFields  = parentClazz.getDeclaredFields();
            fieldList.addAll(Arrays.asList(fields));
            fieldList.addAll(Arrays.asList(parentFields));
            for (Field field : fieldList) {
                String fieldName = field.getName();
                boolean tableFieldExists = field.isAnnotationPresent(TableField.class);
                String type = field.getGenericType().toString();

                if(tableFieldExists){
                    TableField tableField = field.getDeclaredAnnotation(TableField.class);
                    fieldName = tableField.value();
                }
                String finalFieldName = fieldName;
                list.forEach(t->{
                    if(finalFieldName.equals(t.getColumnName())){
                        t.setColumnName(field.getName());
                        if("class [Ljava.lang.String;".equals(type)){
                            t.setColumnType("String[]");
                        }
                        if(t.getColType() != null){
                            switch (t.getColType()){
                                case "text":
                                    t.setColumnType("String");
                                    break;
                                case "varchar":
                                    if(t.getColumnComment() != null && t.getColumnComment().endsWith("list")){
                                        t.setColumnType("List<String>");
                                    }else {
                                        t.setColumnType("String");
                                    }
                                    break;
                                case "int":
                                    t.setColumnType("Integer");
                                    break;
                                case "date":
                                    t.setColumnType("LocalDate");
                                    break;
                                case "timestamp":
                                case "datetime":
                                    t.setColumnType("LocalDateTime");
                                    break;
                                default:
                                    break;
                            }
                        }
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

    private static String firstCharLower(String str) {
        if(str == null){
            return null;
        }
        if(str.length() == 1){
            return str.toLowerCase();
        }
        return str.substring(0,1).toLowerCase() + str.substring(1);
    }

    private static String firstCharUp(String str) {
        if(str == null){
            return null;
        }
        if(str.length() == 1){
            return str.toUpperCase();
        }
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }

    /**
     * 带下划线的字符串转为驼峰
     * 例如：hello_world->HelloWorld
     * @param str 转换前字符串
     * @return 转换后的驼峰式命名的字符串
     */
    private static String toCamelCase(String str) {
        StringBuilder result = new StringBuilder();
        if (str == null || str.isEmpty()) {
            return "";
        } else if (!str.contains("_")) {
            // 不含下划线，不转换
            return firstCharUp(str);
        }
        // 用下划线将原始字符串分割
        String camel[] = str.split("_");
        for (String s :  camel) {
            // 跳过空字符串
            if (s.isEmpty()) {
                continue;
            }
            result.append(firstCharUp(s));
        }
        return result.toString();
    }
}
