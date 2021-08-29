package com.aladdin.mis.engineering.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectPlanUser;
import com.aladdin.mis.engineering.vo.ProjectPlanUserVo;
import com.aladdin.mis.engineering.qo.ProjectPlanUserQo;
import com.github.pagehelper.PageInfo;
/**
 * ProjectPlanUserService
 * @author cles
 * @date 2021-08-29T23:32:31.856
*/
public interface ProjectPlanUserService extends GlobalService<ProjectPlanUser>  {
    /**
     * 分页查询
     * @param qo
     * @return
     */
    PageInfo<ProjectPlanUserVo> paginate(ProjectPlanUserQo qo);

    /**
     * 删除项目计划参与人员
     * @param entity
     * @return flag
     */
    boolean remove(ProjectPlanUser entity);

    /**
     * 更新项目计划参与人员
     * @param entity
     * @return flag
     */
    boolean update(ProjectPlanUser entity);

    /**
     * 保存项目计划参与人员
     * @param entity
     * @return m
     */
    ProjectPlanUser save(ProjectPlanUser entity);

}
