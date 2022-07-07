package com.aladdin.mis.engineering.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

/**
 * 项目计划日志
 * @author cles
 * @date 2022-07-05 21:58:10
*/
@Table("project_task_log")
@Data
public class ProjectTaskLog extends GlobalModel {
    /**
     * 任务主键
     */
    @TableField("task_id")
    private Integer taskId;

    /**
     * taskPicture
     */
    @TableField("task_picture")
    private String taskPicture;

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
