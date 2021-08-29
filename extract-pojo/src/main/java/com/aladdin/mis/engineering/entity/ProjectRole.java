package com.aladdin.mis.engineering.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 项目角色
 * @author cles
 * @date 2021-08-29T23:32:45.164
*/
@Table("project_role")
@Data
public class ProjectRole extends GlobalModel {
    /**
角色代码
    */
    @TableField("code")
    private String code;

    /**
角色名称
    */
    @TableField("name")
    private String name;

    /**
角色描述
    */
    @TableField("comments")
    private String comments;

}
