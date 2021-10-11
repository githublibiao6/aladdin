package com.aladdin.mis.engineering.qo;

import com.aladdin.mis.engineering.entity.ProjectRole;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 项目角色查询实体 
 * @author cles
 * @date 2021-08-29T23:32:45.165
*/
@Data
public class ProjectRoleQo extends ProjectRole {

    private Integer page;
    private Integer limit;
}
