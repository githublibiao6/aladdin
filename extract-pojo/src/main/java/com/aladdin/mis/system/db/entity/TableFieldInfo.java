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
    private String tableName;
    private String fieldName;
    private Object fieldValue;
    private String colName;
    private String colType;
    private String colLength;
    private String columnName;
    private String columnType;
    private String columnComment;
    private boolean pk;

}
