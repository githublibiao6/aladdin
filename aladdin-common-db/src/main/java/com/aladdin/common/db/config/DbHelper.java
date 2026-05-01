package com.aladdin.common.db.config;

import com.aladdin.common.db.bean.Record;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 数据库操作辅助
 *
 * @author cles
 * @date 2026/04/30
 */
@Slf4j
public class DbHelper {

    private static DbHelper instance = null;

    private DbHelper() {
    }

    public synchronized static DbHelper getInstance() {
        if (instance == null) {
            instance = new DbHelper();
        }
        return instance;
    }

    private DruidPooledConnection getConnection(DruidDataSource dataSource) {
        DruidPooledConnection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            log.info("数据源{}获取不到连接", dataSource.getUrl());
            e.printStackTrace();
        }
        return conn;
    }

    public static int save(DruidDataSource dataSource, String sql) {
        DruidPooledConnection conn = DbHelper.getInstance().getConnection(dataSource);
        Statement stmt = null;
        int count;
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            count = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count > 0) {
                conn.commit();
                ResultSet rs = stmt.getGeneratedKeys();
                while (rs.next()) {
                    return rs.getInt(1);
                }
            } else {
                conn.rollback();
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            closeConnection(null, conn, stmt);
        }
        return 0;
    }

    public static int update(DruidDataSource dataSource, String sql) {
        DruidPooledConnection conn = DbHelper.getInstance().getConnection(dataSource);
        Statement stmt = null;
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            int rs = stmt.executeUpdate(sql);
            if (rs > 0) {
                conn.commit();
            } else {
                conn.rollback();
            }
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static List<Map<String, Object>> find(DruidDataSource dataSource, String sql) {
        DruidPooledConnection conn = DbHelper.getInstance().getConnection(dataSource);
        Statement stmt = null;
        ResultSet rs = null;
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {
                Record record = new Record();
                for (int i = 0; i < columnCount; i++) {
                    String columnName = metaData.getColumnLabel(i + 1);
                    String columnValue = rs.getString(columnName);
                    record.setString(columnName, columnValue);
                }
                list.add(record.getColumns());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            closeConnection(rs, conn, stmt);
        }
        return list;
    }

    public static List<JSONObject> findList(DruidDataSource dataSource, String sql) {
        DruidPooledConnection conn = DbHelper.getInstance().getConnection(dataSource);
        Statement stmt = null;
        ResultSet rs = null;
        List<JSONObject> list = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {
                JSONObject obj = new JSONObject();
                for (int i = 0; i < columnCount; i++) {
                    String columnName = metaData.getColumnLabel(i + 1);
                    Object columnValue = rs.getObject(columnName);
                    if (columnValue == null) {
                        obj.put(columnName, null);
                        continue;
                    }
                    if (columnValue instanceof Timestamp) {
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        LocalDateTime timeValue = ((Timestamp) columnValue).toLocalDateTime();
                        obj.put(columnName, dtf.format(timeValue));
                        continue;
                    }
                    obj.put(columnName, columnValue);
                }
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            closeConnection(rs, conn, stmt);
        }
        return list;
    }

    private static void closeConnection(ResultSet rs, DruidPooledConnection conn, Statement stmt) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
