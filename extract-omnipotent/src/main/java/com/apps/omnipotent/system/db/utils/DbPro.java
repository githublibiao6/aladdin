package com.apps.omnipotent.system.db.utils;
/**
 * Created by cles on 2020/5/10 22:53
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSONObject;
import com.apps.omnipotent.system.db.bean.TableInfo;
import com.apps.omnipotent.system.db.config.MainDb;
import com.apps.omnipotent.system.db.factory.DbMaker;
import com.apps.omnipotent.system.utils.StringUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @description: 数据库操作实体
 * @author cles
 * @Date 2020/5/10 22:53
 */
@Slf4j
@Data
public class DbPro {

    private static DruidDataSource dataSource;
    /**
     * 默认的主键
     */
    private static String DEFAULT_PRIMARY_KEY  = "id";
    public DbPro(){

    }
    public String getUserName(){
        return dataSource.getUsername();
    }

    public String getPassword(){
        return dataSource.getPassword();
    }

    public String getDbType(){
        return dataSource.getDbType();
    }

    public String getTableSchema(){
        if("oracle".equals(getDbType())){
            return getUserName();
        }else if("mysql".equals(getDbType())){
            Map  m =  findFirst("select database() table_schema");
            if(m != null && m.get("table_schema") != null && StringUtil.notBlank(m.get("table_schema").toString())){
                return m.get("table_schema").toString();
            }else {
                return null;
            }
        }
        return null;
    }

    public DbPro(DruidDataSource dataSource){
        DbPro.dataSource = dataSource;
    }

    public  List<Map> find(String sql){
        return DbHelper.find(dataSource,sql);
    }

    public List<JSONObject> findList(String sql){
        return DbHelper.findList(dataSource,sql);
    }
    public Map findFirst(String sql){
        List<Map> list = find(sql);
        if (list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    /**
    * @Description: 根据id删除
    * @Param: [tableName, id]
    * @return: int
    * @Author: cles
    * @Date: 2020/6/14 23:25
    */
    public int  deleteById(String tableName,String primaryKey, String id){
        String sql = DbMaker.getDbSqlMaker(dataSource.getDbType()).deleteSql(tableName, primaryKey, id);
        return DbHelper.update(dataSource, sql);
    }

    public int  delete(String sql){
        DbHelper.update(dataSource , sql);
        return 1;
    }

    public String save(String tableName,String primaryKey,  List<JSONObject> list) {
        JSONObject object = DbMaker.getDbSqlMaker(dataSource.getDbType()).saveSql(tableName, primaryKey , list);
        String sql = object.getString("sql");
        log.info(sql);
        int n = DbHelper.save(dataSource,sql);
        if(n > 0){
            return object.getString("id");
        }
        return null;
    }

    public int update(String tableName ,String primaryKey, List<JSONObject> list) {
        String sql = DbMaker.getDbSqlMaker(dataSource.getDbType()).updateSql(tableName, primaryKey, list);
        log.info(sql);
        return DbHelper.update(dataSource,sql);
    }
}
