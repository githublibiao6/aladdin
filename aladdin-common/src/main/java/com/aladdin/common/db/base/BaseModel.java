package com.aladdin.common.db.base;

import com.aladdin.common.db.annotation.TableField;
import com.aladdin.common.db.bean.TableFieldInfo;
import com.aladdin.common.db.bean.TableInfo;
import com.aladdin.common.db.config.Db;
import com.aladdin.common.db.config.DbPro;
import com.aladdin.common.core.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
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
 * 基础实体模型
 *
 * @author cles
 * @date 2026/04/30
 */
@Slf4j
public abstract class BaseModel implements Serializable {

    public Integer getPrimaryKey() {
        TableInfo info = new TableInfo();
        info.setTableName(getTableName());
        List<TableFieldInfo> list = getTableField();
        String primaryKey = getPrimaryKey(info.getTableName());
        AtomicReference<Integer> id = new AtomicReference<>();
        list.forEach(t -> {
            if (primaryKey.equals(t.getColumnName())) {
                id.set((Integer) t.getFieldValue());
            }
        });
        return id.get();
    }

    public TableInfo saveInfo() {
        TableInfo info = new TableInfo();
        info.setTableName(getTableName());
        List<TableFieldInfo> list = getTableField();
        list.remove(0);
        info.setFields(list);
        String tableName = getTableName();
        Db.use().save(tableName, getPrimaryKey(tableName), list);
        return info;
    }

    public TableInfo deleteInfo() {
        TableInfo info = new TableInfo();
        info.setTableName(getTableName());
        String tableName = getTableName();
        List<TableFieldInfo> list = getTableField();
        String primaryKey = getPrimaryKey(tableName);
        AtomicReference<Integer> id = new AtomicReference<>();
        list.forEach(t -> {
            if (primaryKey.equals(t.getColumnName())) {
                id.set((Integer) t.getFieldValue());
            }
        });
        if (id.get() == null) {
            throw new RuntimeException("primary key can not be null");
        }
        info.setIdValue(id.get());
        return info;
    }

    public boolean deleteById(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new RuntimeException("primary key can not be null");
        }
        String tableName = getTableName();
        int delete = Db.use().deleteById(tableName, getPrimaryKey(tableName), Integer.parseInt(id));
        return delete > 0;
    }

    public TableInfo updateInfo() {
        TableInfo info = new TableInfo();
        info.setTableName(getTableName());
        List<TableFieldInfo> list = getTableField();
        Integer primaryKey = getPrimaryKey();
        if (primaryKey == null) {
            throw new RuntimeException("primary key can not be null");
        }
        info.setIdValue(primaryKey);
        info.setFields(list);
        String tableName = getTableName();
        Db.use().update(tableName, getPrimaryKey(tableName), list);
        return info;
    }

    public BaseModel findById(String id) {
        return null;
    }

    public String getTableName() {
        return DbBaseModelUtil.getTableName(this.getClass());
    }

    private List<TableFieldInfo> getTableField() {
        List<TableFieldInfo> list = new ArrayList<>();
        String tableName = getTableName();
        Class<? extends BaseModel> clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            boolean tableFieldExists = field.isAnnotationPresent(TableField.class);
            String column = field.getName();
            if (tableFieldExists) {
                TableField tableField = field.getDeclaredAnnotation(TableField.class);
                if (!tableField.exist()) {
                    continue;
                }
                column = tableField.value();
            }
            TableFieldInfo obj = new TableFieldInfo();
            Type type = field.getGenericType();
            if (int.class.equals(type) || Integer.class.equals(type)) {
                obj.setColType("int");
                obj.setColumnType("Integer");
            } else if (Double.class.equals(type)) {
                obj.setColType("double");
                obj.setColumnType("Double");
            } else if (Date.class.equals(type)) {
                obj.setColType("date");
                obj.setColumnType("Date");
            } else if (LocalDate.class.equals(type)) {
                obj.setColType("date");
                obj.setColumnType("LocalDate");
            } else if (LocalDateTime.class.equals(type)) {
                obj.setColType("datetime");
                obj.setColumnType("LocalDateTime");
            } else if (LocalTime.class.equals(type)) {
                obj.setColType("time");
                obj.setColumnType("LocalTime");
            } else {
                obj.setColType("varchar");
                obj.setColumnType("String");
            }
            try {
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
                Method getMethod = pd.getReadMethod();
                Object value = getMethod.invoke(this);
                obj.setFieldValue(value);
            } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            obj.setTableName(tableName);
            obj.setColumnName(column);
            list.add(obj);
        }
        TableFieldInfo idField = new TableFieldInfo();
        try {
            PropertyDescriptor pd = new PropertyDescriptor("id", clazz);
            Method getMethod = pd.getReadMethod();
            Object value = getMethod.invoke(this);
            idField.setFieldValue(value);
            idField.setTableName(tableName);
            idField.setColumnName("id");
            idField.setColType("int");
            idField.setColumnType("int");
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        list.add(0, idField);
        return list;
    }

    private String getPrimaryKey(String tableName) {
        return DbBaseModelUtil.getPrimaryKey(tableName);
    }
}
