package com.aladdin.mis.business.blog.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 随笔
 * @author lb
 * @date 2018年5月14日 下午10:33:42
 */
@Table("essay")
@Data
public class Essay extends GlobalModel {

    /**
     * 文本
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String article;
    /**
     * 标题
     */
    private String title;
    /**
     * 重要性
     */
    private Integer importance;
    /**
     * 状态
     */
    private String status;
    /**
     * 发布时间
     */
    @TableField("publish_time")
    private Date publishTime;
    /**
     * 副标题
     */
    @TableField("sub_title")
    private String subTitle;

}
