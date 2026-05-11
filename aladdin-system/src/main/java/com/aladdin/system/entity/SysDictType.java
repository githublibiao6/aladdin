package com.aladdin.system.entity;

import com.aladdin.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统字典类型实体
 *
 * @author cles
 * @date 2026/05/06
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysDictType extends BaseEntity {

    private String dictName;
    private String dictType;
    private Integer status;
}
