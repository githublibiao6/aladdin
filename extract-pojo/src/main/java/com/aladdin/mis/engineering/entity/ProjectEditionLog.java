package com.aladdin.mis.engineering.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 项目版本记录
 * @author cles
 * @date 2022-05-19T22:18:45.563
*/
@Table("project_edition_log")
@Data
public class ProjectEditionLog extends GlobalModel {
    /**
     * editionId版本主键
     */
    @TableField("edition_id")
    private Integer editionId;

    /**
     * versionContent版本目标
     */
    @TableField("version_content")
    private String versionContent;

    /**
     * comments版本描述
     */
    @TableField("comments")
    private String comments;

    /**
     * content操作描述
     */
    @TableField("content")
    private String content;

    /**
     * operationUser操作人
     */
    @TableField("operation_user")
    private String operationUser;

}
