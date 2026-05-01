package com.aladdin.common.db.config;

import com.aladdin.common.db.bean.DataSource;
import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据源配置
 *
 * @author cles
 * @date 2026/04/30
 */
@Slf4j
public class DbConfig {

    private static final String ORACLE_DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
    private static final String MYSQL_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    public boolean createDataSource(String key, String url, String username, String password, String dbType) {
        DruidDataSource druidDataSource;
        try {
            druidDataSource = buildDataSource(url, username, password, dbType);
            if (druidDataSource == null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        log.info("{}数据源初始化成功", key);
        druidDataSource.setName(key);
        Db.setDbSource(key, druidDataSource);
        return true;
    }

    public DruidDataSource buildDataSource(String url, String username, String password, String dbType) {
        DruidDataSource druidDataSource = new DruidDataSource();
        String driveClass;
        if (url == null) {
            return null;
        }
        if (dbType == null) {
            if (url.startsWith("jdbc:mysql")) {
                dbType = "mysql";
            } else if (url.startsWith("jdbc:oracle")) {
                dbType = "oracle";
            }
        }
        if ("mysql".equalsIgnoreCase(dbType)) {
            driveClass = MYSQL_DRIVER_CLASS;
        } else if ("oracle".equalsIgnoreCase(dbType)) {
            driveClass = ORACLE_DRIVER_CLASS;
            druidDataSource.setPoolPreparedStatements(true);
            druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(50);
        } else {
            driveClass = MYSQL_DRIVER_CLASS;
        }
        try {
            Class.forName(driveClass);
            DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        try {
            druidDataSource.setDriverClassName(driveClass);
            druidDataSource.setUrl(url);
            druidDataSource.setUsername(username);
            druidDataSource.setPassword(password);
            druidDataSource.setInitialSize(50);
            druidDataSource.setMaxActive(100);
            druidDataSource.setMaxWait(60000);
            druidDataSource.setMinIdle(40);
            druidDataSource.setTestOnBorrow(true);
            druidDataSource.setTestWhileIdle(true);
            druidDataSource.setValidationQuery("select 1 from dual");
            druidDataSource.setFilters("stat");
            druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
            druidDataSource.setMinEvictableIdleTimeMillis(180000);
            druidDataSource.setKeepAlive(true);
            druidDataSource.setRemoveAbandoned(true);
            druidDataSource.setRemoveAbandonedTimeout(3600);
            druidDataSource.setLogAbandoned(true);
            druidDataSource.init();
            return druidDataSource;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean delDataSources(String key) {
        return false;
    }

    public boolean testDatasource(String driveClass, String url, String username, String password) {
        try {
            Class.forName(driveClass);
            DriverManager.getConnection(url, username, password);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void createDataSourceWithCheck(String key, DataSource dataSource) throws Exception {
        String datasourceId = dataSource.getId();
        log.info("准备创建数据源{}", datasourceId);
        DruidDataSource druidDataSource = Db.getDbSource(key);
        boolean rightFlag = true;
        Connection connection = null;
        try {
            log.info("{}数据源当前闲置连接数：{}", datasourceId, druidDataSource.getPoolingCount());
            long activeCount = druidDataSource.getActiveCount();
            log.info("{}数据源当前活动连接数：{}", datasourceId, activeCount);
            connection = druidDataSource.getConnection();
            log.info("数据源{}正常", datasourceId);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            rightFlag = false;
            log.info("缓存数据源{}已失效，准备删除...", datasourceId);
            if (delDataSources(datasourceId)) {
                log.info("缓存数据源删除成功");
            } else {
                log.info("缓存数据源删除失败");
            }
        } finally {
            if (null != connection) {
                connection.close();
            }
        }
        if (rightFlag) {
            log.info("不需要重新创建数据源");
            return;
        }
        log.info("准备重新创建数据源...");
        createDataSource(key, dataSource);
        log.info("重新创建数据源完成");
    }

    private void createDataSource(String key, DataSource dataSource) {
        String datasourceId = dataSource.getId();
        log.info("准备创建数据源{}", datasourceId);
        String dbType = dataSource.getDbType();
        String username = dataSource.getUsername();
        String password = dataSource.getPassword();
        String url = dataSource.getUrl();
        if (dbType == null) {
            if (url.startsWith("jdbc:mysql")) {
                dbType = "mysql";
            } else if (url.startsWith("jdbc:oracle")) {
                dbType = "oracle";
            }
        }
        String driveClass = MYSQL_DRIVER_CLASS;
        if (testDatasource(driveClass, url, username, password)) {
            boolean result = this.createDataSource(key, url, username, password, dbType);
            if (!result) {
                log.error("数据源{}配置正确，但是创建失败", datasourceId);
            }
        } else {
            log.error("数据源配置有错误");
        }
    }
}
