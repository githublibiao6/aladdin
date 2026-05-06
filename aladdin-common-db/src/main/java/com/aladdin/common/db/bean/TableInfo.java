package com.aladdin.common.db.bean;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 表信息
 *
 * @author cles
 * @date 2026/04/30
 */
@Data
public class TableInfo {

    private Integer idValue;

    private String className;

    private String tableName;

    private String tableComment;

    private List<TableFieldInfo> fields;

    private Map<String, String> columnCol;

    private Map<String, String> colColumn;

    private List<String> pks;
}
