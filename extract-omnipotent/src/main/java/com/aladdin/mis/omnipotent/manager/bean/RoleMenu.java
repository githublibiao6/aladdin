package com.aladdin.mis.omnipotent.manager.bean;

import com.aladdin.mis.omnipotent.system.core.Table;
import com.aladdin.mis.omnipotent.system.core.TableField;
import com.aladdin.mis.omnipotent.system.global.entity.GlobalModel;
import lombok.Data;

/**
 * 菜单model
* @Description
* @MethodName  GlobalModel
* @author lb
* @date 2018年8月20日 下午10:50:54
*
 */
@Table("be_role_menu")
@Data
public class RoleMenu extends GlobalModel {
    private String id;

    @TableField("role_id")
    private String roleId;

    @TableField("menu_id")
    private String menuId;
}
