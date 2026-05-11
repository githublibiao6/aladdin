package com.aladdin.system.entity;

import com.aladdin.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统字典数据实体
 *
 * @author cles
 * @date 2026/05/06
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysDictData extends BaseEntity {

    private Long dictTypeId;
    private String dictLabel;
    private String dictValue;
    private Integer sort;
    private String cssClass;
    private String listClass;
    private Integer status;
}
