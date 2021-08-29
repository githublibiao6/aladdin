package com.aladdin.mis.engineering.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 *
 * @author cles
 * @date 2021-08-29T23:33:30.143
*/
@Table("project_user_role")
@Data
public class ProjectUserRole extends GlobalModel {
    /**

    */
    @TableField("user_id")
    private String userId;

    /**

    */
    @TableField("role_id")
    private String roleId;

    /**

    */
    @TableField("project_id")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date projectId;

}
