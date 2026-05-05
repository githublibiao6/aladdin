package com.aladdin.common.db.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 数据源操作工具
 *
 * @author cles
 * @date 2026/04/30
 */
@Slf4j
@Component
public class Db {

    private static HashMap<String, DruidDataSource> map = new HashMap<>();
    private static DruidDataSource main = null;

    public static void setDbSource(String key, DruidDataSource dataSource) {
        map.put(key, dataSource);
    }

    public static DruidDataSource getDbSource(String key) {
        return map.get(key);
    }

    public static void setMain(DruidDataSource dataSource) {
        log.info("主数据源加入成功");
        main = dataSource;
    }

    public static DbPro use() {
        return new DbPro(main);
    }

    public static DbPro use(String key) {
        DruidDataSource dataSource = map.get(key);
        if (dataSource == null) {
            throw new IllegalArgumentException("Db-" + key + ": Data source not configured");
        }
        return new DbPro(dataSource);
    }
}
