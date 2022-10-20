package com.aladdin.mis.engineering.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 项目任务表
 * @author cles
 * @date 2022-07-05 21:58:00
*/
@Table("project_task")
@Data
public class ProjectTask extends GlobalModel {

    /**
     * relationId关联id
     */
    @TableField("relation_id")
    private Integer relationId;

    /**
     * type关联任务类型
     */
    @TableField("type")
    private String type;

    /**
     * taskName任务名称
     */
    @TableField("task_name")
    private String taskName;

    /**
     * taskComments任务描述
     */
    @TableField("task_comments")
    private String taskComments;

    /**
     * startDate计划k开始时间
     */
    @TableField("start_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;

    /**
     * endDate结束日期
     */
    @TableField("end_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    /**
     * startTime阶段实际开始时间
     */
    @TableField("start_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    /**
     * endTime实际阶段结束时间
     */
    @TableField("end_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    /**
     * target阶段目标
     */
    @TableField("target")
    private String target;

    /**
     * taskPic效果图list
     */
    @TableField("task_pic")
    private List<String> taskPic;

    /**
     * taskLevel任务等级
     */
    @TableField("task_level")
    private Integer taskLevel;

    /**
     * status项目任务阶段状态
     */
    @TableField("status")
    private String status;

    /**
     * userId负责人
     */
    @TableField("user_id")
    private String userId;

    /**
     * parentId父节点主键
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * remark备注信息
     */
    @TableField("remark")
    private String remark;

    /**
     * createUser任务创建人
     */
    @TableField("create_user")
    private String createUser;

    /**
     * grade任务评价星级
     */
    @TableField("grade")
    private Integer grade;

    /**
     * evaluate阶段性评价
     */
    @TableField("evaluate")
    private String evaluate;

}
