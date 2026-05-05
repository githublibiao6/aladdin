package com.aladdin.mis.engineering.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 项目计划参与人员
 * @author cles
 * @date 2022-07-05 21:57:37
*/
@Table("project_plan_user")
@Data
public class ProjectPlanUser extends GlobalModel {

    /**
     * userId
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * planId
     */
    @TableField("plan_id")
    private Integer planId;

    /**
     * status人员状态
     */
    @TableField("status")
    private String status;

    /**
     * roleId角色
     */
    @TableField("role_id")
    private String roleId;

    /**
     * startTime
     */
    @TableField("start_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    /**
     * completeTime
     */
    @TableField("complete_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime completeTime;

    /**
     * grade评价等级
     */
    @TableField("grade")
    private Integer grade;

    /**
     * evaluate评价
     */
    @TableField("evaluate")
    private String evaluate;

    /**
     * 描述
     */
    @TableField("comments")
    private String comments;

}
