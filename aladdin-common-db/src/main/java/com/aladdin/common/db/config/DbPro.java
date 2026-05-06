package com.aladdin.common.db.config;

import com.aladdin.common.db.bean.SqlLog;
import com.aladdin.common.db.bean.TableFieldInfo;
import com.aladdin.common.db.dao.SqlLogDao;
import com.aladdin.common.db.factory.DbMaker;
import com.aladdin.common.db.util.SqlInjectionUtil;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson2.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 数据库操作实体
 *
 * @author cles
 * @date 2026/04/30
 */
@Slf4j
@Data
@Component
public class DbPro {

    private static SqlLogDao sqlLogDao;

    private static DruidDataSource dataSource;

    public DbPro() {
    }

    public static SqlLogDao getSqlLogDao() {
        return sqlLogDao;
    }

    public static void setSqlLogDao(SqlLogDao sqlLogDao) {
        DbPro.sqlLogDao = sqlLogDao;
    }

    public String getUserName() {
        return dataSource.getUsername();
    }

    public String getPassword() {
        return dataSource.getPassword();
    }

    public String getDbType() {
        return dataSource.getDbType();
    }

    public String getTableSchema() {
        if ("oracle".equals(getDbType())) {
            return getUserName();
        } else if ("mysql".equals(getDbType())) {
            Map<String, Object> m = findFirst("select database() table_schema");
            if (m != null && m.get("table_schema") != null && !StringUtils.isEmpty(m.get("table_schema"))) {
                return m.get("table_schema").toString();
            } else {
                return null;
            }
        }
        return null;
    }

    public DbPro(DruidDataSource dataSource) {
        DbPro.dataSource = dataSource;
    }

    public List<Map<String, Object>> baseFind(String sql) {
        return DbHelper.find(dataSource, sql);
    }

    public List<Map<String, Object>> find(String sql) {
        SqlLog logEntity = new SqlLog();
        logEntity.setExecuteSql(sql);
        logEntity.setCode(0);
        LocalDateTime start = LocalDateTime.now();
        logEntity.setStartTime(start);
        List<Map<String, Object>> list = null;
        try {
            list = DbHelper.find(dataSource, sql);
        } catch (Exception e) {
            logEntity.setCode(1);
            logEntity.setErrorMsg(e.getMessage());
        }
        logEntity.setSqlType("Q");
        saveSqlLog(start, logEntity);
        return list;
    }

    public List<JSONObject> findList(String sql) {
        SqlLog logEntity = new SqlLog();
        logEntity.setExecuteSql(sql);
        logEntity.setCode(0);
        LocalDateTime start = LocalDateTime.now();
        logEntity.setStartTime(start);
        List<JSONObject> list;
        try {
            list = DbHelper.findList(dataSource, sql);
        } catch (Exception e) {
            logEntity.setCode(1);
            logEntity.setErrorMsg(e.getMessage());
            list = new ArrayList<>();
        }
        logEntity.setSqlType("Q");
        saveSqlLog(start, logEntity);
        return list;
    }

    public Map findByPrimaryKey(String tableName, String primaryKey, Integer id) {
        SqlInjectionUtil.validateTableName(tableName);
        SqlInjectionUtil.validateColumnName(primaryKey);
        String sql = "select * from " + tableName + " m where " + primaryKey + "=" + id;
        SqlLog logEntity = new SqlLog();
        logEntity.setExecuteSql(sql);
        logEntity.setTableName(tableName);
        logEntity.setTableId(id);
        logEntity.setCode(0);
        LocalDateTime start = LocalDateTime.now();
        logEntity.setStartTime(start);
        Map result = null;
        try {
            result = findFirst(sql);
        } catch (Exception e) {
            logEntity.setCode(1);
            logEntity.setErrorMsg(e.getMessage());
        }
        logEntity.setSqlType("D");
        logEntity.setTableId(id);
        saveSqlLog(start, logEntity);
        return result;
    }

    public Map<String, Object> findFirst(String sql) {
        List<Map<String, Object>> list = DbHelper.find(dataSource, sql);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public int deleteById(String tableName, String primaryKey, Integer id) {
        SqlInjectionUtil.validateTableName(tableName);
        SqlInjectionUtil.validateColumnName(primaryKey);
        String sql = DbMaker.getDbSqlMaker(dataSource.getDbType()).deleteSql(tableName, primaryKey, id);
        SqlLog logEntity = new SqlLog();
        logEntity.setExecuteSql(sql);
        logEntity.setTableName(tableName);
        logEntity.setCode(0);
        LocalDateTime start = LocalDateTime.now();
        logEntity.setStartTime(start);
        int result = 0;
        try {
            result = DbHelper.update(dataSource, sql);
        } catch (Exception e) {
            logEntity.setCode(1);
            logEntity.setErrorMsg(e.getMessage());
        }
        logEntity.setSqlType("D");
        logEntity.setTableId(id);
        saveSqlLog(start, logEntity);
        return result;
    }

    public int delete(String sql) {
        SqlLog logEntity = new SqlLog();
        logEntity.setExecuteSql(sql);
        logEntity.setCode(0);
        LocalDateTime start = LocalDateTime.now();
        logEntity.setStartTime(start);
        int n = 0;
        try {
            n = DbHelper.update(dataSource, sql);
        } catch (Exception e) {
            logEntity.setCode(1);
            logEntity.setErrorMsg(e.getMessage());
        }
        logEntity.setSqlType("D");
        saveSqlLog(start, logEntity);
        return n;
    }

    public int save(String tableName, String primaryKey, List<TableFieldInfo> list) {
        SqlInjectionUtil.validateTableName(tableName);
        SqlInjectionUtil.validateColumnName(primaryKey);
        JSONObject object = DbMaker.getDbSqlMaker(dataSource.getDbType()).saveSql(tableName, primaryKey, list);
        String sql = object.getString("sql");
        log.info(sql);
        int n = 0;
        SqlLog logEntity = new SqlLog();
        logEntity.setExecuteSql(sql);
        logEntity.setTableName(tableName);
        logEntity.setCode(0);
        LocalDateTime start = LocalDateTime.now();
        logEntity.setStartTime(start);
        try {
            n = DbHelper.save(dataSource, sql);
            if (n > 0) {
                return n;
            }
        } catch (Exception e) {
            logEntity.setCode(1);
            logEntity.setErrorMsg(e.getMessage());
        }
        logEntity.setSqlType("S");
        saveSqlLog(start, logEntity);
        return 0;
    }

    public int update(String tableName, String primaryKey, List<TableFieldInfo> list) {
        SqlInjectionUtil.validateTableName(tableName);
        SqlInjectionUtil.validateColumnName(primaryKey);
        String sql = DbMaker.getDbSqlMaker(dataSource.getDbType()).updateSql(tableName, primaryKey, list);
        SqlLog logEntity = new SqlLog();
        logEntity.setExecuteSql(sql);
        logEntity.setCode(0);
        logEntity.setTableName(tableName);
        LocalDateTime start = LocalDateTime.now();
        logEntity.setStartTime(start);
        int result = 0;
        try {
            result = DbHelper.update(dataSource, sql);
        } catch (Exception e) {
            logEntity.setCode(1);
            logEntity.setErrorMsg(e.getMessage());
        }
        logEntity.setSqlType("U");
        saveSqlLog(start, logEntity);
        return result;
    }

    private void saveSqlLog(LocalDateTime start, SqlLog logEntity) {
        LocalDateTime end = LocalDateTime.now();
        logEntity.setEndTime(end);
        Duration duration = Duration.between(start, end);
        long cost = duration.toMillis();
        logEntity.setCost(cost);
        if (sqlLogDao != null) {
            sqlLogDao.save(logEntity);
        }
    }
}
