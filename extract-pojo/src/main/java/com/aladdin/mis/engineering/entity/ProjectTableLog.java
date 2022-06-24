package com.aladdin.mis.engineering.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

/**
 * 项目表日志
 * @author cles
 * @date 2022-06-22T21:14:00.788
*/
@Table("project_table_log")
@Data
public class ProjectTableLog extends GlobalModel {
    /**
     * tableId项目表主键
     */
    @TableField("table_id")
    private Integer tableId;

    /**
     * content日志内容
     */
    @TableField("content")
    private String content;

    /**
     * icon
     */
    @TableField("icon")
    private String icon;

    /**
     * type展示类型
     */
    @TableField("type")
    private String type;

    /**
     * operationUser
     */
    @TableField("operation_user")
    private String operationUser;

    /**
     * operationSql
     */
    @TableField("operation_sql")
    private String operationSql;

}
