package com.aladdin.mis.common.system.service.impl;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.dao.db.config.MainDb;
import com.aladdin.mis.dao.global.GlobalMapper;
import com.aladdin.mis.dao.utils.Db;
import com.aladdin.mis.manager.bean.Admin;
import com.aladdin.mis.system.base.BaseModel;
import com.aladdin.mis.system.db.entity.TableFieldInfo;
import com.aladdin.mis.system.db.entity.TableInfo;
import com.aladdin.mis.util.BaseModelUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 功能描述：
 *  < 全局service方法 >
 * @Description:
 * @Author: cles
 * @Date: 2020/6/23 23:23
 * @return:
 * @version: 1.0.0
 */
public class  GlobalServiceImpl<T extends BaseModel>  implements GlobalService<T> {


    private static final String CREATE_TIME_FIELD = "sys001";
    private static final String UPDATE_TIME_FIELD = "sys002";
    private static final String CREATE_USER_FIELD = "sys003";
    private static final String UPDATE_USER_FIELD = "sys004";

    @Autowired
    GlobalMapper<T> mapper;


    @Override
    public <T> T detailQuery(Integer id) {

        Class<T> clazz = (Class<T>) getT();
        String tableName = BaseModelUtil.getTableName(clazz);
        String primaryKey = BaseModelUtil.getPrimaryKey(tableName);
        TableInfo table = MainDb.getTableInfo(tableName);
        String sql = "select * from "+tableName+" m where "+primaryKey+"="+id ;
        Map map = Db.use().findFirst(sql);
        List<TableFieldInfo> list = table.getFields();
        JSONObject json = new JSONObject();
        list.forEach(t->{
            json.put(t.getFieldName(), map.get(t.getColumnName()));
        });
        return JSONObject.parseObject(json.toJSONString(),clazz);
    }

    @Override
    public <T> T insertSelective(BaseModel baseModel) {
        TableInfo table = baseModel.save();
        String tableName = table.getTableName();
        List<TableFieldInfo> list = table.getFields();
        Admin admin = (Admin) SecurityUtils.getSubject().getPrincipal();
        TableFieldInfo user = new TableFieldInfo();
        user.setFieldValue(admin.getId());
        user.setFieldName(CREATE_USER_FIELD);
        user.setTableName(tableName);
        user.setColumnName(CREATE_USER_FIELD);
        user.setColType("int");
        list.add(user);
        TableFieldInfo time = new TableFieldInfo();
        time.setFieldValue(new Date());
        time.setFieldName(CREATE_TIME_FIELD);
        time.setTableName(tableName);
        time.setColumnName(CREATE_TIME_FIELD);
        time.setColType("Date");
        list.add(time);
        int id = Db.use().save(tableName, "id", list);
        return  detailQuery(id);
    }

    @Override
    public boolean deleteById(Integer primaryKey) {
        Class<T> m = getT();
        return Db.use().deleteById(BaseModelUtil.getTableName(m) , "id",  primaryKey) > 0;
    }

    @Override
    public  boolean updateSelective(BaseModel baseModel) {
        TableInfo table = baseModel.update();
        String tableName = table.getTableName();
        List<TableFieldInfo> list = table.getFields();
        TableFieldInfo user = new TableFieldInfo();
        Admin admin = (Admin) SecurityUtils.getSubject().getPrincipal();
        user.setFieldValue(admin.getId());
        user.setFieldName(UPDATE_USER_FIELD);
        user.setTableName(tableName);
        user.setColumnName(UPDATE_USER_FIELD);
        user.setColType("int");
        list.add(user);
        TableFieldInfo time = new TableFieldInfo();
        time.setFieldValue(new Date());
        time.setFieldName(UPDATE_TIME_FIELD);
        time.setTableName(tableName);
        time.setColumnName(UPDATE_TIME_FIELD);
        time.setColType("Date");
        list.add(time);
        int count = Db.use().update(tableName, "id", list);
        if(count > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(BaseModel baseModel) {
        try{
            TableInfo table = baseModel.delete();
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
