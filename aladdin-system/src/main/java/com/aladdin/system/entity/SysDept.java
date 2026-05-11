package com.aladdin.system.entity;

import com.aladdin.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统部门实体
 *
 * @author cles
 * @date 2026/05/06
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysDept extends BaseEntity {

    private Long parentId;
    private String deptName;
    private Integer sort;
    private String leader;
    private String phone;
    private String email;
    private Integer status;
}
