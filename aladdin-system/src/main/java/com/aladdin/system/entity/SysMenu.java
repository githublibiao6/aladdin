package com.aladdin.system.entity;

import com.aladdin.common.core.domain.BaseEntity;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Table("sys_menu")
public class SysMenu extends BaseEntity {

    private String menuName;
    private Long parentId;
    private Integer sort;
    private String path;
    private String component;
    private String menuType;
    private String perms;
    private String icon;
    private Integer status;
}
