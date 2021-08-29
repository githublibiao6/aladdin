package com.aladdin.mis.engineering.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 项目表字段
 * @author cles
 * @date 2021-08-29T23:33:00.402
*/
@Table("project_table_field")
@Data
public class ProjectTableField extends GlobalModel {
    /**

    */
    @TableField("project_id")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date projectId;

    /**
字段名称
    */
    @TableField("column_name")
    private String columnName;

    /**
字段类型
    */
    @TableField("column_type")
    private String columnType;

    /**
字段描述
    */
    @TableField("column_comment")
    private String columnComment;

    /**
备注信息
    */
    @TableField("remark")
    private String remark;

    /**
表状态
    */
    @TableField("status")
    private String status;

}
