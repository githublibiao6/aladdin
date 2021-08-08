package com.aladdin.mis.annotation.entity;
/**
 * Created by cles on 2020/5/31 15:10
 */

import com.aladdin.mis.system.db.entity.TableInfo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author cles
 * @Date 2020/5/31 15:10
 */
public class TableHelper {
    private static final Map<Class<?>, TableInfo> TABLE_INFO_CACHE = new ConcurrentHashMap();
    private static final String DEFAULT_ID_NAME = "id";

    public TableHelper() {
    }
}
