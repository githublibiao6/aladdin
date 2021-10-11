package com.aladdin.mis.engineering.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
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
