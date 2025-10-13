package com.aladdin.mis.base.entity;

import com.aladdin.mis.base.model.BaseModel;
import lombok.Data;

@Data
public class Person extends BaseModel {


    private String name;

    private Integer age;
}
