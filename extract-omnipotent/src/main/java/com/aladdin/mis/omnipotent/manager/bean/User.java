package com.aladdin.mis.omnipotent.manager.bean;


import com.aladdin.mis.system.annotation.entity.Table;
import com.aladdin.mis.system.annotation.entity.TableField;
import com.aladdin.mis.omnipotent.system.global.entity.GlobalModel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 人员model
* @Description
* @MethodName  GlobalModel
* @author lb
* @date 2018年8月20日 下午10:50:54
 */
@Table("be_user")
@Data
public class User extends GlobalModel {

    /**
     * 名称
     */
    private String name;
    /**
     *  密码
     */
    private String password;
    /**
     * 身份证号
     */
    @TableField("citizen_no")
    private String citizenNo;

    /**
     * 照片地址
     */
    @TableField("photo_uri")
    private String photoUri;
    /**
     * 性别
     */
    private String sex;

    /**
     * 位置
     */
    private String position;
    /**
     * 说明
     */
    private String comments;
    /**
     * 生日
     */
    private String birth;
    /**
     * 国籍
     */
    private String nation;

    /**
     * 婚姻
     */
    private String marriage;

    /**
     * 手机
     */
    private String phone;

    /**
     * 办公室电话
     */
    @TableField("office_no")
    private String officeNo;

    /**
     * 邮件
     */
    @TableField("officeNo")
    private String email;

    /**
     * 学历
     */
    private String education;

    /**
     * 学位
     */
    private String degree;

    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("contract_start")
    private Date contractStart;

    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("contract_end")
    private Date contractEnd;

}
