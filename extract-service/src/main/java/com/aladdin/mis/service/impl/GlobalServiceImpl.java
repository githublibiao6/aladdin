package com.aladdin.mis.service.impl;

import com.aladdin.mis.dao.db.config.MainDb;
import com.aladdin.mis.dao.global.GlobalMapper;
import com.aladdin.mis.dao.utils.Db;
import com.aladdin.mis.service.GlobalService;
import com.aladdin.mis.system.base.BaseModel;
import com.aladdin.mis.system.db.entity.TableFieldInfo;
import com.aladdin.mis.system.db.entity.TableInfo;
import com.aladdin.mis.util.BaseModelUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

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
    public int insertSelective(BaseModel baseModel) {
        TableInfo table = baseModel.save();
        int id = Db.use().save(table.getTableName(), "id", table.getFields());
        return  id;
//        return baseModel;
    }

    @Override
    public boolean deleteById(String primaryKey) {

        return false;
    }

    @Override
    public int updateSelective(BaseModel baseModel) {
        TableInfo table = baseModel.update();
        return Db.use().update(table.getTableName(), "id", table.getFields());
    }

    @Override
    public boolean delete(BaseModel baseModel) {
        try{
//            baseModel.delete();
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
