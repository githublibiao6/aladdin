package com.aladdin.mis.blog.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 随笔
 * @author lb
 * @date 2018年5月14日 下午10:33:42
 */
@Table("essay")
@Data
public class Essay extends GlobalModel {

    /**
     * 发布时间
     */
    @TableField("publish_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime publishTime;

    /**
     * 作者
     */
    @TableField("publisher")
    private String publisher;

    /**
     * 文本
     */
    @TableField("article")
    private String article;
    /**
     * 标题
     */
    @TableField("title")
    private String title;
    /**
     * 重要性
     */
    @TableField("importance")
    private Integer importance;
    /**
     * 状态
     */
    @TableField("status")
    private String status;

    /**
     * 副标题
     */
    @TableField("sub_title")
    private String subTitle;

}
