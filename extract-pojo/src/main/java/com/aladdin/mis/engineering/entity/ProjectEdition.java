package com.aladdin.mis.engineering.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 项目版本记录
 * @author cles
 * @date 2022-05-11T01:37:39.275
*/
@Table("project_edition")
@Data
public class ProjectEdition extends GlobalModel {
    /**
     * projectId项目主键
     */
    @TableField("project_id")
    private Integer projectId;

    /**
     * edition版本号
     */
    @TableField("edition")
    private String edition;

    /**
     * versionContent版本内容
     */
    @TableField("version_content")
    private String versionContent;

    /**
     * startDate开始时间
     */
    @TableField("start_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;

    /**
     * endDate结束时间
     */
    @TableField("end_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    /**
     * comments版本描述
     */
    @TableField("comments")
    private String comments;

    /**
     * status版本状态
     */
    @TableField("status")
    private String status;

}
