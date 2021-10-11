package com.aladdin.mis.engineering.qo;

import com.aladdin.mis.engineering.entity.ProjectTableField;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 项目表字段查询实体 
 * @author cles
 * @date 2021-08-31T22:05:10.398
*/
@Data
public class ProjectTableFieldQo extends ProjectTableField {

    private Integer page;
    private Integer limit;
}
