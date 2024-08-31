package com.aladdin.mis.business.entity;

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
 * 帖子
 * @author cles
 * @date 2024-08-31 21:50:30
*/
@Table("biz_post")
@Data
public class BizPost extends GlobalModel {

    /**
     * userId作者
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * postNum帖子号码
     */
    @TableField("post_num")
    private Integer postNum;

    /**
     * title标题
     */
    @TableField("title")
    private String title;

    /**
     * subTitle副标题
     */
    @TableField("sub_title")
    private String subTitle;

    /**
     * postType帖子类别（讨论，分享）
     */
    @TableField("post_type")
    private Integer postType;

    /**
     * content帖子内容
     */
    @TableField("content")
    private String content;

    /**
     * readNum阅读数量
     */
    @TableField("read_num")
    private Integer readNum;

    /**
     * collectNum收藏数量
     */
    @TableField("collect_num")
    private Integer collectNum;

    /**
     * replyNum回复数量
     */
    @TableField("reply_num")
    private Integer replyNum;

    /**
     * thumbNum点赞数量
     */
    @TableField("thumb_num")
    private Integer thumbNum;

    /**
     * treadNum不喜欢（踩）数量
     */
    @TableField("tread_num")
    private Integer treadNum;

    /**
     * status帖子状态
     */
    @TableField("status")
    private String status;

    /**
     * lastReplyTime最后回复时间
     */
    @TableField("last_reply_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastReplyTime;

    /**
     * publishTime
     */
    @TableField("publish_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime publishTime;

    /**
     * publisher作者
     */
    @TableField("publisher")
    private String publisher;

    /**
     * postLabel帖子标签
     */
    @TableField("post_label")
    private String postLabel;

    /**
     * top是否置顶
     */
    @TableField("top")
    private Integer top;

    /**
     * topTime置顶时间
     */
    @TableField("top_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime topTime;

    /**
     * topEndTime置顶结束时间
     */
    @TableField("top_end_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime topEndTime;

    /**
     * topType置顶类型
     */
    @TableField("top_type")
    private Integer topType;

}
