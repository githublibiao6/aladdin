package com.aladdin.common.db.base;

import com.aladdin.common.db.annotation.Table;
import com.aladdin.common.db.config.MainDb;

/**
 * 基础模型工具类
 *
 * @author cles
 * @date 2026/04/30
 */
public class DbBaseModelUtil {

    public static String getTableName(Class<?> clazz) {
        Table table = clazz.getAnnotation(Table.class);
        if (table != null) {
            return table.value();
        }
        return clazz.getSimpleName();
    }

    public static String getPrimaryKey(String tableName) {
        return "id";
    }
}
