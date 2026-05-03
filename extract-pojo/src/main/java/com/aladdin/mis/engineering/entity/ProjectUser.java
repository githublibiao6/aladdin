package com.aladdin.mis.engineering.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

/**
 *
 * @author cles
 * @date 2021-10-12T00:48:58.610
*/
@Table("project_user")
@Data
public class ProjectUser extends GlobalModel {

    /**
    * 人员
    */
    @TableField("user_id")
    private Integer userId;

    /**
    * 角色，多个用,隔开
    */
    @TableField("role_id")
    private String roleId;

    /**
    * 项目主键
    */
    @TableField("project_id")
    private Integer projectId;

    /**
    * 版本主键
    */
    @TableField("edition_id")
    private Integer editionId;

}
