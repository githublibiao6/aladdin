package com.aladdin.mis.business.blog.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("publish_time")
    private Date publishTime;
    /**
     * 副标题
     */
    @TableField("sub_title")
    private String subTitle;

}
