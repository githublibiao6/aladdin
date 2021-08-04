package com.aladdin.mis.omnipotent.love.entity;

import com.aladdin.mis.omnipotent.system.core.Table;
import com.aladdin.mis.omnipotent.system.global.entity.GlobalModel;
import lombok.Data;

/**
 * 随笔
 * @author lb
 * @date 2018年5月14日 下午10:33:42
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
     * 重要性
     */
    private Integer importance;
    /**
     * 状态
     */
    private String status;
//    /**
//     * 发布时间
//     */
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @TableField("publish_time")
//    private Date publishTime;
//    /**
//     * 副标题
//     */
//    @TableField("sub_title")
//    private String subTitle;
//
//    /**
//     * 创建者
//     */
//    @TableField("create_user")
//    private String createUser;
//    /**
//     * 创建时间
//     */
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @TableField("create_time")
//    private Date createTime;
//
//    /**
//     * 创建者
//     */
//    @TableField("modify_user")
//    private String modifyUser;
//    /**
//     * 创建时间
//     */
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @TableField("modify_time")
//    private Date modifyTime;
//
//    /**
//     * 生效标志
//     */
//    @TableField("effective_flag")
//    private String effectiveFlag;
//    /**
//     * 删除标志
//     */
//    @TableField("delete_flag")
//    private String deleteFlag;
}
