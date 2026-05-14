package com.aladdin.system.entity;

import com.aladdin.common.core.domain.BaseEntity;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Table("sys_dict_data")
public class SysDictData extends BaseEntity {

    private Long dictTypeId;
    private String dictLabel;
    private String dictValue;
    private Integer sort;
    private String cssClass;
    private String listClass;
    private Integer status;
}
