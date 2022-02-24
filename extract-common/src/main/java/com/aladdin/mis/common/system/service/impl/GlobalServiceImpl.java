package com.aladdin.mis.common.system.service.impl;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.dao.db.config.MainDb;
import com.aladdin.mis.dao.utils.Db;
import com.aladdin.mis.system.base.BaseModel;
import com.aladdin.mis.system.db.entity.TableFieldInfo;
import com.aladdin.mis.system.db.entity.TableInfo;
import com.aladdin.mis.system.user.vo.OmUser;
import com.aladdin.mis.util.BaseModelUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.time.LocalDateTime;
import java.util.*;

/**
 * 功能描述：
 *  < 全局service方法 >
 * @Author: cles
 * @Date: 2020/6/23 23:23
 * @version: 1.0.0
 */
public class  GlobalServiceImpl<T extends BaseModel>  implements GlobalService<T> {


    private static final String CREATE_TIME_FIELD = "sys001";
    private static final String UPDATE_TIME_FIELD = "sys002";
    private static final String CREATE_USER_FIELD = "sys003";
    private static final String UPDATE_USER_FIELD = "sys004";
    private static final String FLAG = "sys005";

    @Override
    public <T> T detailQuery(Integer id) {
        Class<T> clazz = (Class<T>) getT();
        return detailQuery(id, clazz);
    }

    private <T> T detailQuery(Integer id, Class<T> clazz) {

        String tableName = BaseModelUtil.getTableName(clazz);
        String primaryKey = BaseModelUtil.getPrimaryKey(tableName);
        TableInfo table = MainDb.getTableInfo(tableName);
        String sql = "select * from "+tableName+" m where "+primaryKey+"="+id ;
        Map map = Db.use().findFirst(sql);
        if(map == null){
            return null;
        }
        List<TableFieldInfo> list = table.getFields();
        JSONObject json = new JSONObject();
        list.forEach(t->{
            if("List<String>".equals(t.getColumnType()) && map.get(t.getColName()) != null){
                String value = map.get(t.getColName()).toString();
                value = value.substring(1, value.length()-1);
                json.put(t.getColumnName(), Arrays.asList(value.split(",")));
            }if("LocalDateTime".equals(t.getColumnType()) && map.get(t.getColName()) != null){
                String value = map.get(t.getColName()).toString();
                value = value.substring(0, 19);
                json.put(t.getColumnName(), value);
            }else {
                json.put(t.getColumnName(), map.get(t.getColName()));
            }
        });
        return JSONObject.parseObject(json.toJSONString(),clazz);
    }

    @Override
    public <T> T insertSelective(BaseModel baseModel) {
        return  (T)detailQuery(insert(baseModel), baseModel.getClass());
    }

    @Override
    public Integer insert(BaseModel baseModel) {
        TableInfo table = MainDb.getTableInfo(getTableName(baseModel.getClass()));
        table.setFields(setTableField(table.getFields(), baseModel));
        String tableName = table.getTableName();
        List<TableFieldInfo> list = table.getFields();
        OmUser user = (OmUser) SecurityUtils.getSubject().getPrincipal();
        list.forEach(t->{
            if(CREATE_USER_FIELD.equals(t.getColumnName())){
                t.setFieldValue(user.getUserId());
            }
            if(CREATE_TIME_FIELD.equals(t.getColumnName())){
                t.setFieldValue(LocalDateTime.now());
            }
            if(FLAG.equals(t.getColumnName())){
                t.setFieldValue(1);
            }
        });
        try{
            Integer id = Db.use().save(tableName, "id", list);
            return id;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public  boolean updateSelective(BaseModel baseModel) {
        TableInfo table = MainDb.getTableInfo(getTableName(baseModel.getClass()));
        table.setFields(setTableField(table.getFields(), baseModel));
        String tableName = table.getTableName();
        List<TableFieldInfo> list = table.getFields();
        OmUser user = (OmUser) SecurityUtils.getSubject().getPrincipal();
//        TableFieldInfo user = new TableFieldInfo();
        list.forEach(t->{
            if(UPDATE_USER_FIELD.equals(t.getColumnName())){
                t.setFieldValue(user.getUserId());
            }
            if(UPDATE_TIME_FIELD.equals(t.getColumnName())){
                t.setFieldValue(LocalDateTime.now());
            }
        });
        int count = Db.use().update(tableName, "id", list);
        return count > 0;
    }

    private List<TableFieldInfo> setTableField(List<TableFieldInfo> list , BaseModel baseModel)  {
        Field[] fields = baseModel.getClass().getDeclaredFields();
        Map<String, Object> map = new HashMap<>(16);
        for (Field field : fields){
            try {
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), baseModel.getClass());
                Method getMethod = pd.getReadMethod();
                Object value = getMethod.invoke(baseModel);
                String column = field.getName();
                map.put(column,value);
            } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        // 单独获取主键
        try {
            PropertyDescriptor pd = new PropertyDescriptor("id", baseModel.getClass());
            Method getMethod = pd.getReadMethod();
            Object value = getMethod.invoke(baseModel);
            map.put("id",value);
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        list.forEach(t->{
            t.setFieldValue(map.get(t.getColumnName()));
        });
        return list;
    }

    private String getTableName(Class clazz){
        return BaseModelUtil.getTableName(clazz);
    }

    @Override
    public boolean deleteById(Integer primaryKey) {
        Class<T> m = getT();
        return Db.use().deleteById(BaseModelUtil.getTableName(m) , "id",  primaryKey) > 0;
    }

    @Override
    public boolean delete(BaseModel baseModel) {
        try{
            TableInfo table = baseModel.deleteInfo();
            return Db.use().deleteById(table.getTableName(), "id",  table.getIdValue()) > 0;
        }catch (Exception e){
            return false;
        }
    }

    private Class<T> getT() {
        Type type = getClass().getGenericSuperclass();
        Type[] parameter = ((ParameterizedType) type).getActualTypeArguments();
        return (Class<T>)parameter[0];
    }
}
