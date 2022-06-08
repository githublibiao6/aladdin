package com.aladdin.mis.engineering.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 项目缺陷管理
 * @author cles
 * @date 2022-06-07T00:17:28.231
*/
@Table("project_bug")
@Data
public class ProjectBug extends GlobalModel {
    /**
     * relationId关联主键（项目主键或版本主键）
     */
    @TableField("relation_id")
    private Integer relationId;

    /**
     * bugType1 项目bug 2 版本bug
     */
    @TableField("bug_type")
    private String bugType;

    /**
     * bugName 缺陷标题0
     */
    @TableField("bug_title")
    private String bugTitle;

    /**
     * bugPicture文件类别
     */
    @TableField("bug_picture")
    private String bugPicture;

    /**
     * bug 等级 1 轻微 2 普通 3 严重 4 紧急 5 致命
     */
    @TableField("bug_level")
    private String bugLevel;

    /**
     * bugPriority优先等级 1 低 2 中 3 高 4 紧急
     */
    @TableField("bug_priority")
    private String bugPriority;

    /**
     * commentsbug描述 复现流程
     */
    @TableField("comments")
    private String comments;

    /**
     * completeTime完成时间
     */
    @TableField("complete_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime completeTime;

    /**
     * 缺陷修复星级
     */
    @TableField("complete_star")
    private LocalDateTime completeStar;

    /**
     * status文件状态  1 打开 2 处理 3 完成 4 测试 5 复提 6 关闭
     */
    @TableField("status")
    private String status;

    /**
     * bugReason问题原因 1 未发现问题 2 设计如此 3 代码缺陷 4 需求问题
     */
    @TableField("bug_reason")
    private String bugReason;

    /**
     * regressionComments回归描述
     */
    @TableField("regression_comments")
    private String regressionComments;

    /**
     * regressionComments回归描述
     */
    @TableField("found_user")
    private String foundUser;

}
