package com.apps.omnipotent.system.db.config;
/**
 * Created by cles on 2020/5/8 0:01
 */

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description: 数据源配置
 * @author cles
 * @Date 2020/5/8 0:01
 */
@Slf4j
public class DbSourceHolder {
    /**
    * 对当前线程的操作-线程安全的
     */
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    /**
     *  调用此方法，切换数据源
     * @param dataSource
     */
    public static void setDataSource(String dataSource) {

        contextHolder.set(dataSource);
        log.info("已切换到数据源:{}",dataSource);
    }

    // 获取数据源
    public static String getDataSource() {
        return contextHolder.get();
    }

    // 删除数据源
    public static void clearDataSource() {
        contextHolder.remove();
        log.info("已切换到主数据源");
    }
}
