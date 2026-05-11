package com.aladdin.mis.identity.entity;

import com.aladdin.common.db.annotation.Table;
import com.aladdin.common.db.annotation.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

import java.util.List;

/**
 * 菜单model
* @Description
* @MethodName  GlobalModel
* @author lb
* @date 2018："："0："下午10:50:54
*
 */
@Table("be_role")
@Data
public class Role extends GlobalModel {

    @TableField("code")
    private String code;

    @TableField("name")
    private String name;

    @TableField("app_id")
    private Integer appId;

    @TableField("comments")
    private String comments;

    @TableField(exist = false)
    private Integer roleId;

    @TableField(exist = false)
    private String appName;

    @TableField(exist = false)
    private List<Role> children;

    @TableField(exist = false)
    private boolean hasChildren;

    @TableField(exist = false)
    private String menus;

}
