package com.aladdin.mis.engineering.qo;

import com.aladdin.mis.engineering.entity.ProjectPlanUser;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 项目计划参与人员查询实体 
 * @author cles
 * @date 2021-08-29T23:32:31.851
*/
@Data
public class ProjectPlanUserQo extends ProjectPlanUser {

    private Integer page;
    private Integer limit;
}
