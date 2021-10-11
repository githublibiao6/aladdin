package com.aladdin.mis.engineering.qo;

import com.aladdin.mis.engineering.entity.ProjectUser;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 查询实体 
 * @author cles
 * @date 2021-10-12T00:48:58.701
*/
@Data
public class ProjectUserQo extends ProjectUser {

    private Integer page;
    private Integer limit;
}
