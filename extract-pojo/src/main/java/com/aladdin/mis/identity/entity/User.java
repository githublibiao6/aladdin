package com.aladdin.mis.identity.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 *
 * @author cles
 * @date 2024-08-27 23:36:22
*/
@Table("user")
@Data
public class User extends GlobalModel {

    /**
     * account登录账号
     */
    @TableField("account")
    private String account;

    /**
     * password
     */
    @TableField("password")
    private String password;

    /**
     * signature个性签名
     */
    @TableField("signature")
    private String signature;

    /**
     * salt
     */
    @TableField("salt")
    private String salt;

    /**
     * userName用户名
     */
    @TableField("user_name")
    private String userName;

    /**
     * phone
     */
    @TableField("phone")
    private String phone;

    /**
     * email
     */
    @TableField("email")
    private String email;

    /**
     * sex性别
     */
    @TableField("sex")
    private String sex;

    /**
     * photoUri头像地址
     */
    @TableField("photo_uri")
    private String photoUri;

    /**
     * birth
     */
    @TableField("birth")
    private String birth;

    /**
     * ipCityip城市
     */
    @TableField("ip_city")
    private String ipCity;

    /**
     * domicileCode户籍code
     */
    @TableField("domicile_code")
    private String domicileCode;

    /**
     * domicile户籍
     */
    @TableField("domicile")
    private String domicile;

    /**
     * areaCode所在地code
     */
    @TableField("area_code")
    private String areaCode;

    /**
     * address地址
     */
    @TableField("address")
    private String address;

    /**
     * virtualCode虚拟地址code
     */
    @TableField("virtual_code")
    private String virtualCode;

    /**
     * virtualAddress虚拟地址
     */
    @TableField("virtual_address")
    private String virtualAddress;

    /**
     * qq
     */
    @TableField("qq")
    private String qq;

    /**
     * weChat
     */
    @TableField("we_chat")
    private String weChat;

    /**
     * zfb支付宝账号
     */
    @TableField("zfb")
    private String zfb;

    /**
     * degree
     */
    @TableField("degree")
    private String degree;

    /**
     * status人员状态
     */
    @TableField("status")
    private String status;

    /**
     * userType用户类型
     */
    @TableField("user_type")
    private Integer userType;

    /**
     * vipLevelvip等级
     */
    @TableField("vip_level")
    private Integer vipLevel;

    /**
     * score积分
     */
    @TableField("score")
    private Integer score;

    /**
     * money余额（分）
     */
    @TableField("money")
    private Integer money;

    /**
     * notes备注
     */
    @TableField("notes")
    private String notes;

    /**
     * lastLoginTime最近一次登陆时间
     */
    @TableField("last_login_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastLoginTime;

    /**
     * errorTimes密码输错次数
     */
    @TableField("error_times")
    private Integer errorTimes;

    /**
     * updatePwdTime更新密码的时间
     */
    @TableField("update_pwd_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatePwdTime;

    /**
     * openIdopenId
     */
    @TableField("open_id")
    private String openId;

}
