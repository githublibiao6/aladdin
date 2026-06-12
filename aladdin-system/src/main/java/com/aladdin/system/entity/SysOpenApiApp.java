package com.aladdin.system.entity;

import com.aladdin.common.core.domain.BaseEntity;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Open-API应用实体
 *
 * @author cles
 * @date 2026/06/12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table("sys_open_api_app")
public class SysOpenApiApp extends BaseEntity {

    /** 应用名称 */
    private String appName;
    /** AccessKey */
    private String accessKey;
    /** SecretKey */
    private String secretKey;
    /** 绑定的系统用户ID */
    private Long bindUserId;
    /** 状态 1正常/0禁用 */
    private Integer status;
    /** 租户ID */
    private Long tenantId;
}
