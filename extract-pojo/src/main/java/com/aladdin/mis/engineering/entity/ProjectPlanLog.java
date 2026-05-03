package com.aladdin.mis.engineering.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

/**
 * 项目计划日志
 * @author cles
 * @date 2022-07-06 23:03:24
*/
@Table("project_plan_log")
@Data
public class ProjectPlanLog extends GlobalModel {

    /**
     * planId缺陷主键
     */
    @TableField("plan_id")
    private Integer planId;

    /**
     * planPicture
     */
    @TableField("plan_picture")
    private String planPicture;

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
