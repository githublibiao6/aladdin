package com.aladdin.mis.system.db.entity;
/**
 * Created by cles on 2020/5/31 20:02
 */

import lombok.Data;

import java.util.List;

/**
 * @description: 表信息
 * @author cles
 * @Date 2020/5/31 20:02
 */
@Data
public class TableInfo {
    private String className;
    private String tableName;
    private String tableComment;
    private List<TableFieldInfo> fields;
    private List<String> pks;
}
