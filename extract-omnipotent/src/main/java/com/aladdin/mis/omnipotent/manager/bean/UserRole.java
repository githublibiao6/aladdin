package com.aladdin.mis.omnipotent.manager.bean;


import com.aladdin.mis.system.annotation.entity.Table;
import com.aladdin.mis.system.annotation.entity.TableField;
import com.aladdin.mis.omnipotent.system.global.entity.GlobalModel;
import lombok.Data;

/**
 * 用户角色model
* @author cles
 * @date 2018年8月20日 下午10:50:54
 */
@Table("be_user_role")
@Data
public class UserRole extends GlobalModel {

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
