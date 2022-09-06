package com.aladdin.mis.engineering.vo;

import com.aladdin.mis.engineering.entity.ProjectPlan;
import lombok.Data;

/**
 * 项目计划清单应用层实体
 * @author cles
 * @date 2022-07-04 21:42:33
*/
@Data
public class ProjectPlanVo extends ProjectPlan {

    private String userName;
}
