package com.aladdin.mis.engineering.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

/**
 * 项目版本文件资料
 * @author cles
 * @date 2022-05-25T00:29:11.434
*/
@Table("project_file")
@Data
public class ProjectFile extends GlobalModel {

    /**
     * relationId关联主键（项目主键或版本主键）
     */
    @TableField("relation_id")
    private Integer relationId;

    /**
     * fileName文件名
     */
    @TableField("file_name")
    private String fileName;

    /**
     * fileName文件类别
     */
    @TableField("file_category")
    private String fileCategory;

    /**
     * file文件大小
     */
    @TableField("file_size")
    private String fileSize;

    /**
     * fileType文件类型 1 项目文件 2 版本文件
     */
    @TableField("file_type")
    private String fileType;

    /**
     * fileUrl文件地址
     */
    @TableField("file_url")
    private String fileUrl;

    /**
     * minThumbnail缩略图
     */
    @TableField("min_thumbnail")
    private String minThumbnail;

    /**
     * midThumbnail 中缩略图
     */
    @TableField("mid_thumbnail")
    private String midThumbnail;

    /**
     * maxThumbnail 大缩略图
     */
    @TableField("max_thumbnail")
    private String maxThumbnail;

    /**
     * fileLevel文件等级 1 普通文件 2 重要文件 3 核心文件
     */
    @TableField("file_level")
    private String fileLevel;

    /**
     * comments版本描述
     */
    @TableField("comments")
    private String comments;

    /**
     * status文件状态  0 废弃 1正常
     */
    @TableField("status")
    private String status;

    /**
     * 下载次数
     */
    @TableField("downloadCount")
    private Integer downloadCount;

}
