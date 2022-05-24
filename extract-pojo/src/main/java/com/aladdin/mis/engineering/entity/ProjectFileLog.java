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
 * 项目文件记录
 * @author cles
 * @date 2022-05-25T00:28:57.814
*/
@Table("project_file_log")
@Data
public class ProjectFileLog extends GlobalModel {
    /**
     * fileId文件主键
     */
    @TableField("file_id")
    private Integer fileId;

    /**
     * fileName版本目标
     */
    @TableField("file_name")
    private String fileName;

    /**
     * fileType
     */
    @TableField("file_type")
    private String fileType;

    /**
     * fileUrl
     */
    @TableField("file_url")
    private String fileUrl;

    /**
     * minThumbnail
     */
    @TableField("min_thumbnail")
    private String minThumbnail;

    /**
     * midThumbnail
     */
    @TableField("mid_thumbnail")
    private String midThumbnail;

    /**
     * maxThumbnail
     */
    @TableField("max_thumbnail")
    private String maxThumbnail;

    /**
     * fileLevel
     */
    @TableField("file_level")
    private String fileLevel;

    /**
     * comments版本描述
     */
    @TableField("comments")
    private String comments;

    /**
     * status
     */
    @TableField("status")
    private String status;

    /**
     * content操作描述
     */
    @TableField("content")
    private String content;

    /**
     * operationUser操作人
     */
    @TableField("operation_user")
    private String operationUser;

    /**
     * type展示类型
     */
    @TableField("type")
    private String type;

    /**
     * icon图标
     */
    @TableField("icon")
    private String icon;

}
