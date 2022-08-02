package com.aladdin.mis.engineering.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectPlan;
/**
 * ProjectPlanService
 * @author cles
 * @date 2022-07-04 21:42:33
*/
public interface ProjectPlanService extends GlobalService<ProjectPlan>  {


    /**
     * 更新
     * @param entity
     * @return
     */
    boolean update(ProjectPlan entity);

    /**
     * 保存
     * @param entity
     * @return
     */
    boolean save(ProjectPlan entity);

    /**
     * 开始计划
     * @param entity
     * @return
     */
    boolean startPlan(ProjectPlan entity);

    /**
     * 完成计划
     * @param entity
     * @return
     */
    boolean completePlan(ProjectPlan entity);

    /**
     * 暂停计划
     * @param entity
     * @return
     */
    boolean hangPlan(ProjectPlan entity);

    /**
     * 删除表
     * @param data
     * @return
     */
    boolean deletePlan(ProjectPlan data);

}
