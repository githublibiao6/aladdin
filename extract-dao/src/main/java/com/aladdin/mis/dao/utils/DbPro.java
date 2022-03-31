package com.aladdin.mis.dao.utils;
/**
 * Created by cles on 2020/5/10 22:53
 */

import com.aladdin.mis.dao.db.factory.DbMaker;
import com.aladdin.mis.dao.system.SqlLogDao;
import com.aladdin.mis.system.db.entity.TableFieldInfo;
import com.aladdin.mis.system.entity.SqlLog;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description: 数据库操作实体
 * @author cles
 * @Date 2020/5/10 22:53
 */
@Slf4j
@Data
@Component
public class DbPro {

    private static SqlLogDao sqlLogDao;

    private static DruidDataSource dataSource;
    /**
     * 默认的主键
     */
    private static String DEFAULT_PRIMARY_KEY  = "id";
    public DbPro(){

    }

    public static SqlLogDao getSqlLogDao() {
        return sqlLogDao;
    }

    public static void setSqlLogDao(SqlLogDao sqlLogDao) {
        DbPro.sqlLogDao = sqlLogDao;
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

    public List<Map> baseFind(String sql){
        return DbHelper.find(dataSource,sql);
    }

    public List<Map> find(String sql){
        SqlLog log = new SqlLog();
        log.setExecuteSql(sql);
        log.setCode(0);
        LocalDateTime start = LocalDateTime.now();
        log.setStartTime(start);
        List<Map> list = null;
        try{
            list = DbHelper.find(dataSource,sql);
        }catch (Exception e){
            log.setCode(1);
            log.setErrorMsg(e.getMessage());
        }
        log.setSqlType("Q");
        saveSqlLog(start, log);
        return list;
    }

    public List<JSONObject> findList(String sql){
        SqlLog log = new SqlLog();
        log.setExecuteSql(sql);
        log.setCode(0);
        LocalDateTime start = LocalDateTime.now();
        log.setStartTime(start);
        List<JSONObject> list = new ArrayList<>();
        try{
            list = DbHelper.findList(dataSource,sql);
        }catch (Exception e){
            log.setCode(1);
            log.setErrorMsg(e.getMessage());
        }
        log.setSqlType("Q");
        saveSqlLog(start, log);
        return list;
    }


    public Map findByPrimaryKey(String tableName, String primaryKey, Integer id) {
        String sql = "select * from "+tableName+" m where "+primaryKey+"="+id ;
        SqlLog log = new SqlLog();
        log.setExecuteSql(sql);
        log.setTableName(tableName);
        log.setTableId(id);
        log.setCode(0);
        LocalDateTime start = LocalDateTime.now();
        log.setStartTime(start);
        Map result = null;
        try{
            result = findFirst(sql);
        }catch (Exception e){
            log.setCode(1);
            log.setErrorMsg(e.getMessage());
        }
        log.setSqlType("D");
        log.setTableId(id);
        saveSqlLog(start, log);
        return result;
    }

    public Map findFirst(String sql){
        List<Map> list = DbHelper.find(dataSource,sql);
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
    public int  deleteById(String tableName,String primaryKey, Integer id){
        String sql = DbMaker.getDbSqlMaker(dataSource.getDbType()).deleteSql(tableName, primaryKey, id);
        SqlLog log = new SqlLog();
        log.setExecuteSql(sql);
        log.setTableName(tableName);
        log.setCode(0);
        LocalDateTime start = LocalDateTime.now();
        log.setStartTime(start);
        int result = 0;
        try{
            result = DbHelper.update(dataSource, sql);
        }catch (Exception e){
            log.setCode(1);
            log.setErrorMsg(e.getMessage());
        }
        log.setSqlType("D");
        log.setTableId(id);
        saveSqlLog(start, log);
        return result;
    }

    public int  delete(String sql){
        SqlLog log = new SqlLog();
        log.setExecuteSql(sql);
        log.setCode(0);
        LocalDateTime start = LocalDateTime.now();
        log.setStartTime(start);
        int n = 0;
        try{
            n = DbHelper.update(dataSource , sql);
        }catch (Exception e){
            log.setCode(1);
            log.setErrorMsg(e.getMessage());
        }
        log.setSqlType("D");
        saveSqlLog(start, log);
        return n;
    }

    public int save(String tableName,String primaryKey,  List<TableFieldInfo> list) {
        JSONObject object = DbMaker.getDbSqlMaker(dataSource.getDbType()).saveSql(tableName, primaryKey , list);
        String sql = object.getString("sql");
        log.info(sql);
        int n = 0;
        SqlLog log = new SqlLog();
        log.setExecuteSql(sql);
        log.setTableName(tableName);
        log.setCode(0);
        LocalDateTime start = LocalDateTime.now();
        log.setStartTime(start);
        try{
            n = DbHelper.save(dataSource,sql);
            if(n > 0){
                return n;
            }
        }catch (Exception e){
            log.setCode(1);
            log.setErrorMsg(e.getMessage());
        }
        log.setSqlType("S");
        saveSqlLog(start, log);
        return 0;
    }

    public int update(String tableName ,String primaryKey, List<TableFieldInfo> list) {
        String sql = DbMaker.getDbSqlMaker(dataSource.getDbType()).updateSql(tableName, primaryKey, list);
        SqlLog log = new SqlLog();
        log.setExecuteSql(sql);
        log.setCode(0);
        log.setTableName(tableName);
        LocalDateTime start = LocalDateTime.now();
        log.setStartTime(start);
        int result = 0;
        try{
            result = DbHelper.update(dataSource,sql);
        }catch (Exception e){
            log.setCode(1);
            log.setErrorMsg(e.getMessage());
        }
        log.setSqlType("U");
        saveSqlLog(start, log);
        return result;
    }

    private void saveSqlLog(LocalDateTime start,SqlLog log){
        LocalDateTime end = LocalDateTime.now();
        log.setEndTime(end);

        Duration duration = Duration.between(start, end);
        long cost = duration.toMillis();
        log.setCost(cost);
        sqlLogDao.save(log);
    }

}
