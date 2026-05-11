package com.aladdin.mis.love.entity;

import com.aladdin.common.db.annotation.Table;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

/**
 * 随笔
 * @author lb
 * @date 2018："："4："下午10:33:42
 */
@Table("date_log")
@Data
public class DateLog extends GlobalModel {

    /**
     * 文本
     */
    private String article;

    /**
     * 标题
     */
    private String title;

    /**
     * 重要："
     */
    private Integer importance;

    /**
     * 状："
     */
    private String status;

//    /**
//     * 发布时间
//     */
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @TableField("publish_time")
//    private Date publishTime;
//    /**
//     * 副标："
//     */
//    @TableField("sub_title")
//    private String subTitle;
}
