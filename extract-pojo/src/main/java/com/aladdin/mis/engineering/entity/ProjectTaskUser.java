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
 * 任务人员设置
 * @author cles
 * @date 2022-07-05 21:57:55
*/
@Table("project_task_user")
@Data
public class ProjectTaskUser extends GlobalModel {
    /**
     * taskId任务主键
     */
    @TableField("task_id")
    private Integer taskId;

    /**
     * userId人员id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * userType1 指派人员 2 协助人员
     */
    @TableField("user_type")
    private String userType;

    /**
     * status文件状态  1 指派 2 处理 3 完成 4 回归
     */
    @TableField("status")
    private String status;

    /**
     * startTime开始时间
     */
    @TableField("start_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    /**
     * endTime结束时间
     */
    @TableField("end_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    /**
     * workHour工时
     */
    @TableField("work_hour")
    private Double workHour;

    /**
     * comments开发人员 指派备注
     */
    @TableField("comments")
    private String comments;

    /**
     * completeComments完成备注
     */
    @TableField("complete_comments")
    private String completeComments;

    /**
     * grade评价星级
     */
    @TableField("grade")
    private Integer grade;

    /**
     * evaluate
     */
    @TableField("evaluate")
    private String evaluate;

}
