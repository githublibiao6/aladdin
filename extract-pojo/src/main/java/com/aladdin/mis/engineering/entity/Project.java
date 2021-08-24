package com.aladdin.mis.engineering.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 工程项目
 * @author cles
 * @date 2021-08-25T01:30:11.893
*/
@Table("project")
@Data
public class Project extends GlobalModel {
    /**
项目代码
    */
    @TableField("project_code")
    private String projectCode;

    /**
项目名称
    */
    @TableField("project_name")
    private String projectName;

    /**
项目介绍
    */
    @TableField("introduce")
    private String introduce;

    /**
开始时间
    */
    @TableField("start_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;

    /**
结束时间
    */
    @TableField("end_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    /**
项目状态
    */
    @TableField("status")
    private String status;

    /**
备注
    */
    @TableField("remark")
    private String remark;

    /**
状态位(自定义两位状态)
    */
    @TableField("sys006")
    private String sys006;

}
