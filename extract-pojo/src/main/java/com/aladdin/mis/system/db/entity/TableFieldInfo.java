package com.aladdin.mis.system.db.entity;
/**
 * Created by cles on 2020/5/31 20:02
 */

import lombok.Data;

/**
 * @description: 表字段信息
 * @author cles
 * @Date 2020/5/31 20:02
 */
@Data
public class TableFieldInfo {
    /**
     * 表名
     */
    private String tableName;
    /**
     * 字段值
     */
    private Object fieldValue;
    /**
     * 数据库列名称
     */
    private String colName;
    /**
     * 数据库列类型
     */
    private String colType;
    /**
     * 数据库列长度
     */
    private String colLength;
    private String columnName;
    private String columnType;
    private String columnComment;
    private boolean pk;

}
