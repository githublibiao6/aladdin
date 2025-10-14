package com.aladdin.mis.base.entity;

import com.aladdin.mis.base.annotation.Table;
import com.aladdin.mis.base.annotation.TableField;
import com.aladdin.mis.base.model.BaseModel;
import lombok.Data;

@Table("person")
@Data
public class Person extends BaseModel {

    @TableField("name")
    private String name;

    @TableField("age")
    private Integer age;
}
