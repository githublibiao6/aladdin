package com.aladdin.mis.manager.bean;

import com.aladdin.mis.system.base.GlobalModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 人员  类
 *
 * @author lb
 */
@Data
public class Employee extends GlobalModel {

    /**
     * 姓名
     */
    private String name;

    /**
     * 登录密码ID
     */
    private String password;

    private String citizenNo;
    private String sex;
    private String photoUri;

    /**
     * 职位
     */
    private String position;
    @JsonFormat(locale="zh",timezone="GMT+8",pattern="yy-MM-dd")
    private Date birth;
    private String nation;

    /**
     * 政治面貌
     */
    private String polity;

    /**
     * 婚姻状态
     */
    private String marriage;
    private String phone;
    private String officeNo;
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
     * 合同起始时间
     */
    private Date contractStart;

    /**
     * 合同结束时间
     */
    private Date contractEnd;

    /**
     * 在职状态
     */
    private String state;

    /**
     * 说明
     */
    private String notes;

}
