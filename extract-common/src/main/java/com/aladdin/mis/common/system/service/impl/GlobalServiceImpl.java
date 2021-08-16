package com.aladdin.mis.common.system.service.impl;

import com.aladdin.mis.dao.db.config.MainDb;
import com.aladdin.mis.dao.global.GlobalMapper;
import com.aladdin.mis.dao.utils.Db;
import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.system.base.BaseModel;
import com.aladdin.mis.system.db.entity.TableFieldInfo;
import com.aladdin.mis.system.db.entity.TableInfo;
import com.aladdin.mis.util.BaseModelUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
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
    public int insertSelective(BaseModel baseModel) {
        TableInfo table = baseModel.save();
        int id = Db.use().save(table.getTableName(), "id", table.getFields());
        return  id;
//        return baseModel;
    }

    @Override
    public boolean deleteById(Integer primaryKey) {
        Class<T> m = getT();
        return Db.use().deleteById(BaseModelUtil.getTableName(m) , "id",  primaryKey) > 0;
    }

    @Override
    public int updateSelective(BaseModel baseModel) {
        TableInfo table = baseModel.update();
        return Db.use().update(table.getTableName(), "id", table.getFields());
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
