package com.aladdin.mis.identity.entity;


import com.aladdin.common.db.annotation.Table;
import com.aladdin.common.db.annotation.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

/**
 * 用户角色model user_role
* @author cles
 * @date 2018："："0："下午10:50:54
 */
@Table("be_admin_role")
@Data
public class AdminRole extends GlobalModel {

    /**
     * 名称
     */
    @TableField("admin_id")
    private Integer adminId;

    /**
     * 角色
     */
    @TableField("role_id")
    private Integer roleId;
}
