package com.aladdin.system.entity;

import com.aladdin.common.core.domain.BaseEntity;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Table("sys_dept")
public class SysDept extends BaseEntity {

    private Long parentId;
    private String deptName;
    private Integer sort;
    private String leader;
    private String phone;
    private String email;
    private Integer status;

    @Column(ignore = true)
    private List<SysDept> children;
}
