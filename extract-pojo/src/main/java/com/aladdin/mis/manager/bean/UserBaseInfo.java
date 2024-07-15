package com.aladdin.mis.manager.bean;


import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

/**
 * 人员model（个人基本信息）
* @Description
* @MethodName  GlobalModel
* @author lb
* @date 2018年8月20日 下午10:50:54
 */
@Table("user_base_info")
@Data
public class UserBaseInfo extends GlobalModel {

    /**
     * 账号
     */
    private Integer userId;

    /**
     * 说明
     */
    private String comments;

    /**
     * 国籍
     */
    private String nation;

    /**
     * 婚姻
     */
    private String marriage;

    /**
     * 办公室电话
     */
    @TableField("office_no")
    private String officeNo;

    /**
     * 学历
     */
    private String education;

    /**
     * 学位
     */
    private String degree;

    /**
     * 备注
     */
    private String remark;
}
