package com.aladdin.system.entity;

import com.aladdin.common.core.domain.BaseEntity;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户组实体
 *
 * @author cles
 * @date 2026/06/12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table("sys_user_group")
public class SysUserGroup extends BaseEntity {

    /** 用户组名称 */
    private String groupName;
    /** 用户组标识 */
    private String groupKey;
    /** 排序 */
    private Integer sort;
    /** 状态 1正常/0禁用 */
    private Integer status;
    /** 租户ID */
    private Long tenantId;
}
