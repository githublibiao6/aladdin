package com.aladdin.mis.system.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 
 * @author cles
 * @date 2022-02-24T22:09:10.279
*/
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
    private LocalDateTime loginTime;

    /**
    * loginType
    */
    @TableField("login_type")
    private String loginType;

    /**
    * lastLoginTime
    */
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;

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
    private LocalDateTime logoutTime;

}
