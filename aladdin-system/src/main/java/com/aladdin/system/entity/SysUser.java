package com.aladdin.system.entity;

import com.aladdin.common.core.domain.BaseEntity;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Table("sys_user")
public class SysUser extends BaseEntity {

    private String username;
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String avatar;
    private Long deptId;
    private Integer status;

    @Column(ignore = true)
    private String deptName;
}
