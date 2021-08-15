package com.aladdin.mis.manager.bean;

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
@Table("be_role")
@Data
public class Role extends GlobalModel {

    @TableField("code")
    private String code;

    @TableField("name")
    private String name;

    @TableField("comments")
    private String comments;

}
