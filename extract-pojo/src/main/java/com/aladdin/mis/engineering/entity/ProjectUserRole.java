package com.aladdin.mis.engineering.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

/**
 *
 * @author cles
 * @date 2021-08-31T22:03:55.832
*/
@Table("project_user_role")
@Data
public class ProjectUserRole extends GlobalModel {
    /**
    * userId
    */
    @TableField("user_id")
    private String userId;

    /**
    * roleId
    */
    @TableField("role_id")
    private String roleId;

    /**
    * projectId
    */
    @TableField("project_id")
    private Integer projectId;

}
