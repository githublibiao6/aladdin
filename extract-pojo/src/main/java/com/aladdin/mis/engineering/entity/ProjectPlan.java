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
 * 项目计划清单
 * @author cles
 * @date 2022-07-04 21:42:33
*/
@Table("project_plan")
@Data
public class ProjectPlan extends GlobalModel {
    /**
     * projectId
     */
    @TableField("project_id")
    private Integer projectId;

    /**
     * planName计划名称
     */
    @TableField("plan_name")
    private String planName;

    /**
     * startDate
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
     * resultPic效果图list
     */
    @TableField("result_pic")
    private List<String> resultPic;

    /**
     * problem问题记录
     */
    @TableField("problem")
    private String problem;

    /**
     * solved解决方案
     */
    @TableField("solved")
    private String solved;

    /**
     * status阶段状态
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
     * evaluate阶段性评价
     */
    @TableField("evaluate")
    private String evaluate;

}
