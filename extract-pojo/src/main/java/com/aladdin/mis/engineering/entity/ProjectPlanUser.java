package com.aladdin.mis.engineering.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 项目计划参与人员
 * @author cles
 * @date 2021-08-29T23:32:31.850
*/
@Table("project_plan_user")
@Data
public class ProjectPlanUser extends GlobalModel {
    /**

    */
    @TableField("user_id")
    private String userId;

    /**

    */
    @TableField("plan_id")
    private String planId;

}
