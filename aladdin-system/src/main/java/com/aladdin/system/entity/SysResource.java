package com.aladdin.system.entity;

import com.aladdin.common.core.domain.BaseEntity;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 系统资源实体
 * 资源类型：M-菜单，A-接口，F-按钮
 *
 * @author cles
 * @date 2026/06/11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table("sys_resource")
public class SysResource extends BaseEntity {

    private String resourceName;
    private Long parentId;
    private Integer sort;
    private String path;
    private String component;
    private String resourceType;
    private String perms;
    private String icon;
    private Integer status;

    @Column(ignore = true)
    private List<SysResource> children;
}
