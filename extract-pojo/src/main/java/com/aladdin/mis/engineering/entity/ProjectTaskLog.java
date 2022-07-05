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
 * 项目权限日志
 * @author cles
 * @date 2022-07-05 21:58:10
*/
@Table("project_task_log")
@Data
public class ProjectTaskLog extends GlobalModel {
    /**
     * bugId缺陷主键
     */
    @TableField("bug_id")
    private Integer bugId;

    /**
     * bugPicture
     */
    @TableField("bug_picture")
    private String bugPicture;

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

}
