package com.aladdin.mis.engineering.qo;

import lombok.Data;

/**
 * 生成实体
 * @author cles
 * @date 2021-08-31T22:26:17.065
*/
@Data
public class GenerateQo {

    private String tableSchema;

    private String tableName;

    private String tableComment;

}
