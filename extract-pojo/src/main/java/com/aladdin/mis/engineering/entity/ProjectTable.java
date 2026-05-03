package com.aladdin.mis.engineering.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

/**
 * 项目表
 * @author cles
 * @date 2021-09-14T00:07:18.660
*/
@Table("project_table")
@Data
public class ProjectTable extends GlobalModel {

    /**
    * projectId
    */
    @TableField("project_id")
    private Integer projectId;

    /**
     * 版本主键
     */
    @TableField("edition_id")
    private Integer editionId;

    /**
    * tableName
    */
    @TableField("table_name")
    private String tableName;

    /**
    * tableComment表描述
    */
    @TableField("table_comment")
    private String tableComment;

    /**
    * 废弃原因
    */
    @TableField("abandon_reason")
    private String abandonReason;

    /**
    * remark备注信息
    */
    @TableField("remark")
    private String remark;

    /**
    * status表状态
    */
    @TableField("status")
    private String status;

    /**
    * 建表语句
    */
    @TableField("create_sql")
    private String createSql;

}
