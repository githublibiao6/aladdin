package com.aladdin.mis.manager.bean;


import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

/**
 * 用户角色model
* @author cles
 * @date 2018年8月20日 下午10:50:54
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
