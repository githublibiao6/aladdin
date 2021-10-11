package com.aladdin.mis.engineering.qo;

import com.aladdin.mis.engineering.entity.ProjectUserRole;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 查询实体 
 * @author cles
 * @date 2021-08-31T22:03:55.833
*/
@Data
public class ProjectUserRoleQo extends ProjectUserRole {

    private Integer page;
    private Integer limit;
}
