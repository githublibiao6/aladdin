package com.aladdin.mis.system.entity;

import com.aladdin.mis.annotation.entity.Database;
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
 * @date 2022-02-24T23:38:47.804
*/
@Database("bird")
@Table("be_login_log")
@Data
public class BeLoginLog extends GlobalModel {

    /**
    * userId
    */
    @TableField("user_id")
    private Integer userId;

    /**
    * userType
    */
    @TableField("user_type")
    private String userType;

    /**
    * userName
    */
    @TableField("user_name")
    private String userName;

    /**
    * loginIp
    */
    @TableField("login_ip")
    private String loginIp;

    /**
    * loginTime
    */
    @TableField("login_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime loginTime;

    /**
    * loginType
    */
    @TableField("login_type")
    private String loginType;

    /**
    * lastLoginTime
    */
    @TableField("application_id")
    private Integer applicationId;

    /**
    * departId
    */
    @TableField("depart_id")
    private Integer departId;

    /**
    * departName
    */
    @TableField("depart_name")
    private String departName;

    /**
    * sessionId
    */
    @TableField("session_id")
    private String sessionId;

    /**
    * logoutTime
    */
    @TableField("logout_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime logoutTime;

}
