package com.aladdin.mis.engineering.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 缺陷人员设置
 * @author cles
 * @date 2022-06-07T00:17:46.090
*/
@Table("project_bug_user")
@Data
public class ProjectBugUser extends GlobalModel {
    /**
     * bugId缺陷主键
     */
    @TableField("bug_id")
    private Integer bugId;

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
     * 耗费工时
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

}
