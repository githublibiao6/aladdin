package com.aladdin.mis.engineering.qo;

import com.aladdin.mis.engineering.entity.ProjectPlan;
import lombok.Data;

/**
 * 项目计划清单查询实体
 * @author cles
 * @date 2022-07-04 21:42:33
*/
@Data
public class ProjectPlanQo extends ProjectPlan {

    private Integer page;

    private Integer limit;

    /**
     * 关键字条件过滤
     */
    private String  keyWord;
    /**
     * 排序条件
     */
    private String  sortInfo;

    /**
     * 当前用户查询
     */
    private Integer  userId;
}
