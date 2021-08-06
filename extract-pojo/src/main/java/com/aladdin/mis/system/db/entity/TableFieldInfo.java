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
    private String fieldName;
    private String columnName;
    private String columnComment;
    private String colType;
    private String colLength;
    private boolean pk;

}
