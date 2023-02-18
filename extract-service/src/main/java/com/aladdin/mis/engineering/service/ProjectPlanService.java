package com.aladdin.mis.engineering.service;

import com.aladdin.mis.base.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectPlan;
import com.aladdin.mis.engineering.qo.ProjectPlanQo;
import com.aladdin.mis.engineering.vo.ProjectPlanVo;
import com.github.pagehelper.PageInfo;

/**
 * ProjectPlanService
 * @author cles
 * @date 2022-07-04 21:42:33
*/
public interface ProjectPlanService extends GlobalService<ProjectPlan>  {

    /**
     * 获取分页数据
     * @param id
     * @return
     */
    ProjectPlanVo detail(Integer id);

    /**
     * 获取分页数据
     * @param qo
     * @return
     */
    PageInfo<ProjectPlanVo> pageByDto(ProjectPlanQo qo);

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
    Integer save(ProjectPlan entity);

    /**
     * 开始计划
     * @param entity
     * @return
     */
    boolean startPlan(ProjectPlan entity);

    /**
     * 暂停计划
     * @param entity
     * @return
     */
    boolean hangPlan(ProjectPlan entity);

    /**
     *
     * @param entity
     * @return
     */
    boolean continuePlan(ProjectPlan entity);

    /**
     * 完成计划
     * @param entity
     * @return
     */
    boolean completePlan(ProjectPlan entity);

    /**
     * 删除计划
     * @param data
     * @return
     */
    boolean deletePlan(ProjectPlan data);

}
