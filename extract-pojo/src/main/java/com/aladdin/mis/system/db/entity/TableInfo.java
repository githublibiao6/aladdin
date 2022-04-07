package com.aladdin.mis.system.db.entity;
/**
 * Created by cles on 2020/5/31 20:02
 */

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @description: 表信息
 * @author cles
 * @Date 2020/5/31 20:02
 */
@Data
public class TableInfo {
    /**
     * 主键值
     */
    private Integer idValue;
    /**
     * 类名
     */
    private String className;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 表注释
     */
    private String tableComment;
    /**
     * 字段
     */
    private List<TableFieldInfo> fields;

    /**
     * 字段集合映射(column -> col)
     */
    private Map<String,String> columnCol;

    /**
     * 字段集合映射(col -> column)
     */
    private Map<String,String> colColumn;
    /**
     * 主键字段
     */
    private List<String> pks;
}
