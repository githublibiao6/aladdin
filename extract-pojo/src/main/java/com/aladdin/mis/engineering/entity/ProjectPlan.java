package com.aladdin.mis.engineering.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 项目计划
 * @author cles
 * @date 2021-08-31T22:26:17.060
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
    * startDate
    */
    @TableField("start_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;

    /**
    * endDate结束日期
    */
    @TableField("end_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    /**
    * startTime阶段实际开始时间
    */
    @TableField("start_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
    * endTime实际阶段结束时间
    */
    @TableField("end_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /**
    * target阶段目标
    */
    @TableField("target")
    private String target;

    /**
    * resultPic效果图list
    */
    @TableField("result_pic")
    private List<String>  resultPic;

    /**
    * status阶段状态
    */
    @TableField("status")
    private String status;

    /**
    * userId开始日期
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
