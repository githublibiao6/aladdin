package com.aladdin.mis.engineering.qo;

import com.aladdin.mis.engineering.entity.ProjectPlan;
import lombok.Data;

/**
 * 项目计划查询实体
 * @author cles
 * @date 2021-08-31T22:26:17.063
*/
@Data
public class ProjectPlanQo extends ProjectPlan {

    private Integer page;
    private Integer limit;
}
