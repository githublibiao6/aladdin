package com.apps.omnipotent.system.global.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.apps.omnipotent.manager.bean.Menu;
import com.apps.omnipotent.system.core.BaseModel;
import com.apps.omnipotent.system.core.BaseModelUtil;
import com.apps.omnipotent.system.core.TableField;
import com.apps.omnipotent.system.db.bean.TableFieldInfo;
import com.apps.omnipotent.system.db.bean.TableInfo;
import com.apps.omnipotent.system.db.config.MainDb;
import com.apps.omnipotent.system.db.utils.Db;
import com.apps.omnipotent.system.global.dao.GlobalMapper;
import com.apps.omnipotent.system.global.service.GlobalService;
import com.apps.omnipotent.system.pagehelper.entity.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import sun.tools.jar.Main;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
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
public class  GlobalServiceImpl<T extends  BaseModel>  implements GlobalService<T> {

    @Autowired
    GlobalMapper<T> mapper;


    @Override
    public <T> T detailQuery(String id, Class<T> clazz) {

        String tableName = BaseModelUtil.getTableName(clazz);
        String primaryKey = BaseModelUtil.getPrimaryKey(tableName);
        TableInfo table = MainDb.getTableInfo(tableName);
        String sql = "select * from "+tableName+" m where m.sys005='1' and "+primaryKey+"='"+id+"'";
        Map map = Db.use().findFirst(sql);
        List<TableFieldInfo> list = table.getFields();
        JSONObject json = new JSONObject();

        list.forEach(t->{
            json.put(t.getFieldName(), map.get(t.getColumnName()));
        });
        return JSONObject.parseObject(json.toJSONString(),clazz);
    }

    @Override
    public BaseModel insertSelective(BaseModel baseModel) {
        baseModel.save();
        return baseModel;
    }

    @Override
    public boolean deleteById(String primaryKey) {

        return false;
    }

    @Override
    public BaseModel updateSelective(BaseModel baseModel) {
        baseModel.update();
        return baseModel;
    }

    @Override
    public boolean delete(BaseModel baseModel) {
        try{
            baseModel.delete();
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
