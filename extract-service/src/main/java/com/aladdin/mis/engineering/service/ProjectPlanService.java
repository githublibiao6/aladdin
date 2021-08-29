package com.aladdin.mis.engineering.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectPlan;
import com.aladdin.mis.engineering.vo.ProjectPlanVo;
import com.aladdin.mis.engineering.qo.ProjectPlanQo;
import com.github.pagehelper.PageInfo;
/**
 * ProjectPlanService
 * @author cles
 * @date 2021-08-29T23:32:16.050
*/
public interface ProjectPlanService extends GlobalService<ProjectPlan>  {
    /**
     * 分页查询
     * @param qo
     * @return
     */
    PageInfo<ProjectPlanVo> paginate(ProjectPlanQo qo);

    /**
     * 删除项目计划
     * @param entity
     * @return flag
     */
    boolean remove(ProjectPlan entity);

    /**
     * 更新项目计划
     * @param entity
     * @return flag
     */
    boolean update(ProjectPlan entity);

    /**
     * 保存项目计划
     * @param entity
     * @return m
     */
    ProjectPlan save(ProjectPlan entity);

}
