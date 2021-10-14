package com.aladdin.mis.engineering.vo;

import lombok.Data;

/**
 * 生成实体
 * @author cles
 * @date 2021-08-31T22:26:17.065
*/
@Data
public class GenerateFieldsVo {

    private String fieldName;

    private String createTime;

    private String fieldComment;

    private String fieldType;

    private Integer length;

}
