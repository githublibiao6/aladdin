package com.aladdin.mis.engineering.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectPlanUser;
/**
 * ProjectPlanUserService
 * @author cles
 * @date 2022-07-05 21:57:37
*/
public interface ProjectPlanUserService extends GlobalService<ProjectPlanUser>  {

    /**
     * 删除人员
     * @param entity
     * @return
     */
    boolean deleteUser(ProjectPlanUser entity);
}
