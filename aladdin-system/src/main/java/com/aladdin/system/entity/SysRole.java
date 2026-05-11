package com.aladdin.system.entity;

import com.aladdin.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统角色实体
 *
 * @author cles
 * @date 2026/05/06
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRole extends BaseEntity {

    private String roleName;
    private String roleKey;
    private Integer sort;
    private Integer status;
}
