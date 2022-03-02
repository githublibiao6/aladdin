package com.aladdin.mis.manager.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

/**
 *
 * @author cles
 * @date 2022-03-01T22:38:09.003
*/
@Table("be_user_menu")
@Data
public class BeUserMenu extends GlobalModel {
    /**
    * userId
    */
    @TableField("user_id")
    private Integer userId;

    /**
    * menuId
    */
    @TableField("menu_id")
    private Integer menuId;

}
