package com.aladdin.mis.engineering.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
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
    * remark备注信息
    */
    @TableField("remark")
    private String remark;

    /**
    * status表状态
    */
    @TableField("status")
    private String status;

}
