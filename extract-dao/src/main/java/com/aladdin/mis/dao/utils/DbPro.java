package com.aladdin.mis.dao.utils;
/**
 * Created by cles on 2020/5/10 22:53
 */

import com.aladdin.mis.dao.db.factory.DbMaker;
import com.aladdin.mis.system.db.entity.TableFieldInfo;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.Map;

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
            if(m != null && m.get("table_schema") != null && StringUtils.isNotBlank(m.get("table_schema").toString())){
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

    public int save(String tableName,String primaryKey,  List<TableFieldInfo> list) {
        JSONObject object = DbMaker.getDbSqlMaker(dataSource.getDbType()).saveSql(tableName, primaryKey , list);
        String sql = object.getString("sql");
        log.info(sql);
        int n = DbHelper.save(dataSource,sql);
        if(n > 0){
            return n;
        }
        return 0;
    }

    public int update(String tableName ,String primaryKey, List<TableFieldInfo> list) {
        String sql = DbMaker.getDbSqlMaker(dataSource.getDbType()).updateSql(tableName, primaryKey, list);
        log.info(sql);
        return DbHelper.update(dataSource,sql);
    }
}
