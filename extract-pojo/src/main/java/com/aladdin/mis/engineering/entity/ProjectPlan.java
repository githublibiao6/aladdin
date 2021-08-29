package com.aladdin.mis.engineering.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 项目计划
 * @author cles
 * @date 2021-08-29T23:32:16.045
*/
@Table("project_plan")
@Data
public class ProjectPlan extends GlobalModel {
    /**

    */
    @TableField("project_id")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date projectId;

    /**

    */
    @TableField("start_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;

    /**
结束日期
    */
    @TableField("end_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    /**
阶段实际开始时间
    */
    @TableField("start_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
实际阶段结束时间
    */
    @TableField("end_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /**
阶段目标
    */
    @TableField("target")
    private String target;

    /**
阶段状态
    */
    @TableField("status")
    private String status;

    /**
开始日期
    */
    @TableField("user_id")
    private String userId;

    /**
父节点主键
    */
    @TableField("parent_id")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date parentId;

    /**
备注信息
    */
    @TableField("remark")
    private String remark;

    /**
阶段性评价
    */
    @TableField("evaluate")
    private String evaluate;

}
