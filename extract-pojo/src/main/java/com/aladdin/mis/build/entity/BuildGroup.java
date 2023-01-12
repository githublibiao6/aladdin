package com.aladdin.mis.build.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

/**
 * 建设大类
 * @author cles
 * @date 2023-01-12 23:01:40
*/
@Table("build_group")
@Data
public class BuildGroup extends GlobalModel {

    /**
     * groupIcon图标
     */
    @TableField("group_icon")
    private String groupIcon;

    /**
     * groupName
     */
    @TableField("group_name")
    private String groupName;

    /**
     * state0停用1启用
     */
    @TableField("state")
    private String state;

}
