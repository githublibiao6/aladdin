package com.aladdin.mis.identity.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 
 * @author cles
 * @date 2024-08-21 03:38:11
*/
@Table("be_admin_application")
@Data
public class BeAdminApplication extends GlobalModel {

    /**
     * adminId
     */
    @TableField("admin_id")
    private Integer adminId;

    /**
     * appId应用主键
     */
    @TableField("app_id")
    private Integer appId;

}
