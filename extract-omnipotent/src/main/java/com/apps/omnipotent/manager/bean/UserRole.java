package com.apps.omnipotent.manager.bean;


import com.apps.omnipotent.system.core.Table;
import com.apps.omnipotent.system.core.TableField;
import com.apps.omnipotent.system.global.entity.GlobalModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 用户角色model
* @author cles
 * @date 2018年8月20日 下午10:50:54
 */
@Table("be_user_role")
@Data
public class UserRole extends GlobalModel {

    /**
     主键
     */
    @Id
    private String id;
    /**
     * 名称
     */
    @TableField("user_id")
    private String userId;
    /**
     * 角色
     */
    @TableField("role_id")
    private String roleId;
}
