package com.aladdin.mis.manager.bean;


import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 人员model（基础）
* @Description
* @MethodName  GlobalModel
* @author lb
* @date 2018年8月20日 下午10:50:54
 */
@Table("user")
@Data
public class User extends GlobalModel {

    /**
     * 账号
     */
    private String account;

    /**
     * 账号
     */
    private String password;

    /**
     * 加密盐值
     */
    private String salt;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机
     */
    private String phone;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 身份证号
     */
    @TableField("id_card")
    private String idCard;

    /**
     * 身份证号
     */
    @TableField("birth")
    private String birth;

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
     * 住址
     */
    private String address;

    /**
     * 说明
     */
    private String notes;

    /**
     * 人员状态
     */
    private String status;

    /**
     * qq
     */
    private String qq;

    /**
     * 微信
     */
    private String weChart;

    /**
     *  最近一次登录时间
     */
    @TableField("last_login_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime lastLoginTime;

    /**
     * 密码输错次数
     */
    @TableField("error_times")
    private int errorTimes;

    /**
     * 更新密码的时间s
     */
    @TableField("update_pwd_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime updatePwdTime;


}
