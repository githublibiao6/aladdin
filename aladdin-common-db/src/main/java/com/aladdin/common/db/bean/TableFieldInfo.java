package com.aladdin.common.db.bean;

import lombok.Data;

/**
 * 表字段信息
 *
 * @author cles
 * @date 2026/04/30
 */
@Data
public class TableFieldInfo {

    private String tableName;

    private Object fieldValue;

    private String colName;

    private String colType;

    private Integer colLength;

    private String columnName;

    private String columnType;

    private String columnComment;

    private boolean pk;
}
