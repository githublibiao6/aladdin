package com.aladdin.mis.engineering.entity;

import com.aladdin.common.db.annotation.Table;
import com.aladdin.common.db.annotation.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

/**
 * 项目表字："
 * @author cles
 * @date 2021-08-31T22:05:10.397
*/
@Table("project_table_field")
@Data
public class ProjectTableField extends GlobalModel {

    /**
    * projectId
    */
    @TableField("table_name")
    private Integer tableName;

    /**
    * projectId
    */
    @TableField("project_id")
    private Integer projectId;

    /**
    * tableId表主："
    */
    @TableField("table_id")
    private Integer tableId;

    /**
    * columnName字段名称
    */
    @TableField("column_name")
    private String columnName;

    /**
    * columnType字段类型
    */
    @TableField("column_type")
    private String columnType;

    /**
    * columnType字段类型
    */
    @TableField("column_length")
    private Integer columnLength;

    /**
    * columnComment字段描述
    */
    @TableField("column_comment")
    private String columnComment;

    /**
    * remark备注信息
    */
    @TableField("remark")
    private String remark;

    /**
    * status字段状："
    */
    @TableField("status")
    private String status;

    /**
     * 废弃原因
     */
    @TableField("abandon_reason")
    private String abandonReason;

}
