package com.aladdin.system.entity;

import com.aladdin.common.core.domain.BaseEntity;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Table("sys_role")
public class SysRole extends BaseEntity {

    private String roleName;
    private String roleKey;
    private Integer sort;
    private Integer status;
    /** 数据权限范围：1-全部数据 2-自定义数据 3-本部门数据 4-本部门及以下数据 5-仅本人数据 */
    private Integer dataScope;

    @Column(ignore = true)
    private List<Long> deptIds;
}
