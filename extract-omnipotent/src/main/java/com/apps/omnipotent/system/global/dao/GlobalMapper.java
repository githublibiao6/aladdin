package com.apps.omnipotent.system.global.dao;

import com.apps.omnipotent.system.core.BaseModel;
import com.apps.omnipotent.system.core.BaseModelUtil;
import com.apps.omnipotent.system.core.Table;
import com.apps.omnipotent.system.db.bean.TableInfo;
import com.apps.omnipotent.system.db.config.MainDb;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 初始化mapper
 * @author cles
 * @param <T>
 */
@Component

public interface GlobalMapper<T extends BaseModel> {

    /**
     * 根据主键查询实体
     * @param id 主键
     * @param clazz 所需的class
     * @return t
     */
    @SelectProvider(type = GlobalMapper.GlobalProvider.class,method = "detailQuery")
    <T> T detailQuery(String id, Class<T> clazz);

    /**
     * 根据主键查询实体
     * @param id 主键
     * @param clazz 所需的class
     * @return t
     */
    @SelectProvider(type = GlobalMapper.GlobalProvider.class,method = "delete")
    <T> T delete(String id, Class<T> clazz);

    @Slf4j
    class GlobalProvider<T>{

        private String getPrimaryKey(String tableName){
            return  BaseModelUtil.getPrimaryKey(tableName);
        }

        private  String getTableName(Class<T> clazz){
            return  BaseModelUtil.getTableName(clazz);
        }

        public String detailQuery(String id, Class<T> clazz) {
            String tableName = BaseModelUtil.getTableName(clazz);
            String primaryKey = BaseModelUtil.getPrimaryKey(tableName);
            String sql = "select * from "+tableName+" m where m.sys005='1' and "+primaryKey+"='"+id+"'";
            log.info(sql);
            return sql;
        }

        public String delete(String id, Class<T> clazz) {
            String tableName = BaseModelUtil.getTableName(clazz);
            String primaryKey = BaseModelUtil.getPrimaryKey(tableName);
            String sql =  "update "+tableName+" set sys005='0' where "+primaryKey+"='"+id+"'";
            log.info(sql);
            return sql;
        }
    }

}
