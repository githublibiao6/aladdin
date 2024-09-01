package com.aladdin.mis.system.base;
/**
 * Created by cles on 2020/5/31 12:12
 */

import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.common.db.bean.TableFieldInfo;
import com.aladdin.mis.common.db.bean.TableInfo;
import com.aladdin.mis.common.db.config.Db;
import com.aladdin.mis.util.BaseModelUtil;
import org.springframework.util.StringUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @description: 尝试
 * @author cles
 * @Date 2020/5/31 12:12
 */
//public abstract class BaseModel<T extends BaseModel> implements Serializable {
public abstract class BaseModel implements Serializable {

    /**
     * 功能描述：
     *  < 获取主键值 >
     * @Description: save
     * @Author: cles
     * @Date: 2020/6/19 0:18
     * @return: String
     * @version: 1.0.0
     */
    public Integer getPrimaryKey (){
        TableInfo info = new TableInfo();
        info.setTableName(getTableName());
        List<TableFieldInfo> list =  getTableField();
        String primaryKey = getPrimaryKey(info.getTableName());
        AtomicReference<Integer> id = new AtomicReference<>();
        list.forEach(t->{
            if(primaryKey.equals(t.getColumnName())){
                id.set((Integer) t.getFieldValue());
            }
        });
        return id.get();
    }

    /**
     * 功能描述：
     *  < 实体直接保存 >
     * @Description: save
     * @Author: cles
     * @Date: 2020/6/19 0:18
     * @return: String
     * @version: 1.0.0
     */
    public TableInfo saveInfo(){
        TableInfo info = new TableInfo();
        info.setTableName(getTableName());
        List<TableFieldInfo> list =  getTableField();

        list.remove(0);
        info.setFields(list);
        String tableName = getTableName();
        Db.use().save(tableName, getPrimaryKey(tableName), list);
        return info;
    }

    /**
     * 功能描述：
     *  < 直接删除实体 >
     * @Description: delete
     * @Author: cles
     * @Date: 2020/6/19 0:15
     * @return: boolean
     * @version: 1.0.0
     */
    public TableInfo deleteInfo(){
        TableInfo info = new TableInfo();
        info.setTableName(getTableName());
        String tableName = getTableName();
        List<TableFieldInfo> list =  getTableField();
        String primaryKey = getPrimaryKey(tableName);
        AtomicReference<Integer> id = new AtomicReference<>();
        list.forEach(t->{
            if(primaryKey.equals(t.getColumnName())){
                id.set((Integer) t.getFieldValue());
            }
        });
        if(id.get() == null){
            throw new RuntimeException("primary key can not be null");
        }
        info.setIdValue(id.get());
        return info;
    }

    /**
     * 功能描述：
     *  < 根据值删除 >
     * @Description: deleteById
     * @Author: cles
     * @Date: 2020/6/19 0:14
     * @param id 参数1
     * @return: boolean
     * @version: 1.0.0
     */
    public boolean deleteById(String id){
        if(StringUtils.isEmpty(id)){
            throw new RuntimeException("primary key can not be null");
        }
        String tableName = getTableName();
        /*
         * 根据类获取注解信息
         */
        int delete = Db.use().deleteById(tableName, getPrimaryKey(tableName), Integer.parseInt(id));
        return delete > 0;
    }

    /**
     * 功能描述：
     *  < 更新实体>
     * @Description: update
     * @Author: cles
     * @Date: 2020/6/19 0:16
     * @return: boolean
     * @version: 1.0.0
     */
    public TableInfo updateInfo(){
        TableInfo info = new TableInfo();
        info.setTableName(getTableName());
        List<TableFieldInfo> list =  getTableField();

        Integer primaryKey = getPrimaryKey();
        if(primaryKey == null){
            throw new RuntimeException("primary key can not be null");
        }
        info.setIdValue(primaryKey);
        info.setFields(list);
        String tableName = getTableName();
        Db.use().update(tableName, getPrimaryKey(tableName), list);
        return info;
    }

    public BaseModel findById(String id){
        String tableName = getTableName();
        return null;
    }

    /**
     * 功能描述：
     *  < 根据实体类的注解获取表名 >
     * @Description: getTableName
     * @Author: cles
     * @Date: 2020/6/19 0:17
     * @return: java.lang.String
     * @version: 1.0.0
     */
    public String getTableName(){
        return BaseModelUtil.getTableName(this.getClass());
    }

    /**
     * 功能描述：
     *  < 将实体转换，保存表字段映射，值等 >
     * @Description: getTableField
     * @Author: cles
     * @Date: 2020/6/19 0:17
     * @return: java.util.List<com.alibaba.fastjson.JSONObject>
     * @version: 1.0.0
     */
    private List<TableFieldInfo> getTableField()  {
        List<TableFieldInfo> list = new ArrayList<>();
        String tableName = getTableName();
        Class<? extends BaseModel> clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            boolean tableFieldExists = field.isAnnotationPresent(TableField.class);
            String column = field.getName();
            if(tableFieldExists){
                TableField tableField = field.getDeclaredAnnotation(TableField.class);
                if(!tableField.exist()){
                    continue;
                }
                column = tableField.value();
            }
            TableFieldInfo obj = new TableFieldInfo();
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
            try {
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
                Method getMethod = pd.getReadMethod();
                Object value = getMethod.invoke(this);
                // 设置字段值
                obj.setFieldValue(value);
            } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            obj.setTableName(tableName);
            obj.setColumnName(column);
            list.add(obj);
        }
        // 单独获取主键
        TableFieldInfo id = new TableFieldInfo();
        try {
            PropertyDescriptor pd = new PropertyDescriptor("id", clazz);
            Method getMethod = pd.getReadMethod();
            Object value = getMethod.invoke(this);
            id.setFieldValue(value);
            id.setTableName(tableName);
            id.setColumnName("id");
            id.setColType("int");
            id.setColumnType("int");
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        list.add(0, id);
        return list;
    }

    /**
     * @Description: 获取主键
     * @Param: [tableName]
     * @return: java.util.List<java.lang.String>
     * @Author: cles
     * @Date: 2020/6/16 23:31
     */
    private String getPrimaryKey(String tableName){
        return BaseModelUtil.getPrimaryKey(tableName);
    }

}
