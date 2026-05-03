package com.aladdin.mis.identity.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

/**
 *
 * @author cles
 * @date 2024-08-27 23:36:32
*/
@Table("user_base_info")
@Data
public class UserBaseInfo extends GlobalModel {

    /**
     * userId
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * idCard
     */
    @TableField("id_card")
    private String idCard;

    /**
     * name真实姓名
     */
    @TableField("name")
    private String name;

    /**
     * nation民族
     */
    @TableField("nation")
    private String nation;

    /**
     * marriage婚姻
     */
    @TableField("marriage")
    private String marriage;

    /**
     * education教育
     */
    @TableField("education")
    private String education;

    /**
     * degree学历
     */
    @TableField("degree")
    private String degree;

    /**
     * officeNo办公室电话
     */
    @TableField("office_no")
    private String officeNo;

    /**
     * authPhone校验手机号
     */
    @TableField("auth_phone")
    private Integer authPhone;

    /**
     * authQq校验qq
     */
    @TableField("auth_qq")
    private Integer authQq;

    /**
     * authEmail校验邮箱
     */
    @TableField("auth_email")
    private Integer authEmail;

    /**
     * authWeChat校验微信
     */
    @TableField("auth_we_chat")
    private Integer authWeChat;

    /**
     * authZfb校验支付宝
     */
    @TableField("auth_zfb")
    private Integer authZfb;

    /**
     * comments说明
     */
    @TableField("comments")
    private String comments;

}
