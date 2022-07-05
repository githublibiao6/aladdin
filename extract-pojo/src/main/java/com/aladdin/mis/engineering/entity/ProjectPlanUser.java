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
    private String userId;

    /**
     * planId
     */
    @TableField("plan_id")
    private String planId;

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

}
