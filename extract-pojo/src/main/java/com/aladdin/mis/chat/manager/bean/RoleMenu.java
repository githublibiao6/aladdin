package com.aladdin.mis.chat.manager.bean;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
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

    @TableField("role_id")
    private Integer roleId;

    @TableField("menu_id")
    private Integer menuId;

    @TableField(exist = false)
    private boolean disabled;

}
