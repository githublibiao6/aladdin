package com.aladdin.mis.common.vo;

import lombok.Data;

/**
 * 创建表实体
 * @author cles
 */
@Data
public class CreateTableVo {

    /**
     * 表名
     */
    private String tableName;

    /**
     * 模块名
     */
    private String module;

    /**
     * 模块名
     */
    private String path;
}
