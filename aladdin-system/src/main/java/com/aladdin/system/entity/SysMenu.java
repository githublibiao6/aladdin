package com.aladdin.system.entity;

import com.aladdin.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统菜单实体
 *
 * @author cles
 * @date 2026/05/06
 */
@Data
@EqualsAndHashCode(callSuper = true)
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
