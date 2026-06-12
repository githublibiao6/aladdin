package com.aladdin.system.entity;

import com.aladdin.common.core.domain.BaseEntity;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 租户实体
 *
 * @author cles
 * @date 2026/06/12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table("sys_tenant")
public class SysTenant extends BaseEntity {

    /** 租户名称 */
    private String tenantName;
    /** 租户编码（唯一） */
    private String tenantCode;
    /** 联系人 */
    private String contactName;
    /** 联系电话 */
    private String contactPhone;
    /** 域名 */
    private String domain;
    /** 过期时间 */
    private LocalDateTime expireTime;
    /** 状态 1正常/0禁用 */
    private Integer status;
}
