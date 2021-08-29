package com.aladdin.mis.engineering.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 项目表
 * @author cles
 * @date 2021-08-29T23:32:52.583
*/
@Table("project_table")
@Data
public class ProjectTable extends GlobalModel {
    /**

    */
    @TableField("project_id")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date projectId;

    /**

    */
    @TableField("table_name")
    private String tableName;

    /**
表描述
    */
    @TableField("table_comment")
    private String tableComment;

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
