package com.aladdin.mis.engineering.qo;

import com.aladdin.mis.engineering.entity.Project;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 工程项目查询实体 
 * @author cles
 * @date 2021-08-25T01:30:11.897
*/
@Data
public class ProjectQo extends Project {

    private Integer page;
    private Integer limit;
}
