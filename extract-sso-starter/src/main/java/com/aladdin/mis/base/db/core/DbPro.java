package com.aladdin.mis.base.db.core;

import com.aladdin.mis.base.annotation.Table;
import com.aladdin.mis.base.annotation.TableField;
import com.aladdin.mis.base.db.bean.DataSourceDb;
import com.aladdin.mis.base.db.bean.TableFieldInfo;
import com.aladdin.mis.base.db.factory.BaseSqlMaker;
import com.aladdin.mis.base.db.factory.DbFactory;
import com.aladdin.mis.base.db.factory.DbTableFactory;
import com.aladdin.mis.base.db.factory.impl.MysqlFactory;
import com.aladdin.mis.base.db.factory.impl.OracleFactory;
import com.aladdin.mis.base.entity.Person;
import com.aladdin.mis.common.enums.SystemExceptionEnum;
import com.aladdin.mis.common.exception.SystemException;
import com.aladdin.mis.base.mapper.DbMapper;
import com.aladdin.mis.base.model.BaseModel;
import com.aladdin.mis.common.utils.StringUtil;
import com.alibaba.fastjson2.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * @description: 数据库操作实体
 * @author cles
 * @Date 2025/5/10 22:53
 */
@Slf4j
@Data
@Component
public class DbPro {

    @Autowired
    private DbMapper dbMapper;

    private DataSourceDb dataSourceDb;

    private DbFactory dbFactory;

    private DbTableFactory dbTableFactory;

    private BaseSqlMaker sqlMaker;

    private final String primaryKey = "id";

    private Map<String, List<TableFieldInfo>> tableMap = new HashMap<>();

    public DbPro(@Lazy DataSourceDb dataSource){
        this.dataSourceDb = dataSource;
        if(this.dataSourceDb.getUrl().startsWith("jdbc:mysql")){
            dataSourceDb.setDbType("mysql");
        }else if(this.dataSourceDb.getUrl().startsWith("jdbc:oracle")){
            dataSourceDb.setDbType("oracle");
        }
        if("oracle".equals(getDbType())){
            dbFactory = new OracleFactory();
        }else if("mysql".equals(getDbType())){
            dbFactory = new MysqlFactory();
        }
        dbTableFactory = dbFactory.getDbTableFactory();
        sqlMaker = dbFactory.getSqlMaker();
    }

    public String getSaveSql(BaseModel model){
        String tableName = getTableName(model);
        List<TableFieldInfo> fields = getTableFields(tableName, model);
        return saveSql(tableName, fields);
    }


    public String getSelectSql(Integer id){

        return "delete sql";
    }

    public String getDeleteSql(BaseModel model){
        // todo
        return "delete sql";
    }

    public String getUpdateSql(BaseModel model){
        String tableName = getTableName(model);
        List<TableFieldInfo> fields = getTableFields(tableName, model);
        return updateSql(tableName, fields);
    }

    public String getSelectSql(String tableName, Integer id) {
        return  "select * from "+tableName+" m where id="+id ;
    }

    public String deleteSql(String tableName, Long id) {
        return sqlMaker.deleteSql(tableName, primaryKey, id);
    }

    /**
     * 插入，无id数据
     */
    public String saveSql(String tableName, List<TableFieldInfo> list) {
        list.get(list.size()-1).setFieldValue(null);
        return sqlMaker.saveSql(tableName, primaryKey, list);
    }

    public String updateSql(String tableName , List<TableFieldInfo> list) {
        return sqlMaker.updateSql(tableName, primaryKey, list);
    }

    @Deprecated
    public List<Map<String, Object>> find(String sql){
        return dbMapper.find(sql);
    }

    @Deprecated
    public Map<String, Object> findFirst(String sql){
        List<Map<String, Object>> list = find(sql);
        if (!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Deprecated
    public List<JSONObject> findList(String sql){
        List<JSONObject> list = new  ArrayList<>();
        List<Map<String, Object>> data = find(sql);
        for (Map<String, Object> map : data) {
            JSONObject json = new JSONObject();
            json.putAll(map);
            list.add(json);
        }
        return list;
    }


    /**
     * 获取数据库表列表
     * @return
     */
    public List<Map<String, Object>> listTable(){
        return dbTableFactory.listTable(this.getTableSchema());
    }

    /**
     * 获取表字段详细信息
     * @param tableName
     * @return
     */
    public List<Map<String, Object>> listTableColumns(String tableName){
        return dbTableFactory.listTableColumns(this.getTableSchema(), tableName);
    }

    /**
     * 获取表详细信息
     * @param tableName
     * @return
     */
    public Map<String, Object> listTableInfo(String tableName){
        return dbTableFactory.listTableInfo(this.getTableSchema(), tableName);
    }


    private String getTableName(BaseModel model) {
        Class<?> clazz = model.getClass();
        boolean existTable = clazz.isAnnotationPresent(Table.class);
        if(existTable){
            Table table = clazz.getDeclaredAnnotation(Table.class);
            String tableName = table.value();
            if(StringUtil.isEmpty(tableName)){
                throw new SystemException(SystemExceptionEnum.TABLE_NOT_EXIST);
            }
            return tableName;
        }
        throw new SystemException(SystemExceptionEnum.TABLE_NOT_EXIST);
    }

    private List<TableFieldInfo> getTableFields(String tableName, BaseModel model) {
        Class<?> clazz = model.getClass();
        Field[] fields = clazz.getDeclaredFields();

        if(tableMap.get(tableName) == null){
            List<TableFieldInfo> list = new ArrayList<>();
            for (Field field : fields){
                TableFieldInfo obj = new TableFieldInfo();
                boolean tableFieldExists = field.isAnnotationPresent(TableField.class);
                if(tableFieldExists){
                    TableField tableField = field.getDeclaredAnnotation(TableField.class);
                    if(!tableField.exist()){
                        continue;
                    }
                    obj.setColName(tableField.value());
                }
                Type type = field.getGenericType();
                if (int.class.equals(type) || Integer.class.equals(type)) {
                    obj.setColType("int");
                    obj.setColumnType("Integer");
                }else if(Double.class.equals(type)){
                    obj.setColType("double");
                    obj.setColumnType("Double");
                }else if(Date.class.equals(type)){
                    obj.setColType("date");
                    obj.setColumnType("Date");
                }else if(LocalDate.class.equals(type)){
                    obj.setColType("date");
                    obj.setColumnType("LocalDate");
                }else if(LocalDateTime.class.equals(type)){
                    obj.setColType("datetime");
                    obj.setColumnType("LocalDateTime");
                }else if(LocalTime.class.equals(type)){
                    obj.setColType("time");
                    obj.setColumnType("LocalTime");
                }else {
                    obj.setColType("varchar");
                    obj.setColumnType("String");
                }
                obj.setTableName(tableName);
                obj.setColumnName(field.getName());
                list.add(obj);
                tableMap.put(tableName, list);
            }
            try{
                Class<?> superclass =clazz.getSuperclass();
                Field f = superclass.getDeclaredField("id");
                TableFieldInfo obj = new TableFieldInfo();
                obj.setColType("bigint");
                obj.setColName("id");
                obj.setColumnType("Long");
                obj.setColumnName("id");
                obj.setPk(true);
                list.add(obj);
            }catch (Exception e){
                throw new SystemException(SystemExceptionEnum.UNKNOWN_ERROR);
            }
        }
        List<TableFieldInfo> list = tableMap.get(tableName);
        for (int i = 0; i < list.size() - 1; i++) {
            try {
                TableFieldInfo field = list.get(i);
                Field f = clazz.getDeclaredField(field.getColumnName());
                f.setAccessible(true);
                // 设置字段值
                field.setFieldValue(f.get(model));
            } catch (IllegalAccessException | NoSuchFieldException e) {
                throw new SystemException(SystemExceptionEnum.UNKNOWN_ERROR);
            }
        }
        try{
            Field f = clazz.getSuperclass().getDeclaredField("id");
            f.setAccessible(true);
            list.get(list.size()-1).setFieldValue(f.get(model));
        }catch (Exception e){
            throw new SystemException(SystemExceptionEnum.UNKNOWN_ERROR);
        }
        return list;
    }

    public String getUserName(){
        return dataSourceDb.getUsername();
    }

    public String getPassword(){
        return dataSourceDb.getPassword();
    }

    public String getDbType(){
        return dataSourceDb.getDbType();
    }

    public String getTableSchema(){
        if("oracle".equals(getDbType())){
            return getUserName();
        }else if("mysql".equals(getDbType())){
            Map<String, Object>  m =  findFirst("select database() table_schema");
            if(m != null && m.get("table_schema") != null && !StringUtils.isEmpty(m.get("table_schema"))){
                return m.get("table_schema").toString();
            }else {
                return null;
            }
        }
        return null;
    }
}
