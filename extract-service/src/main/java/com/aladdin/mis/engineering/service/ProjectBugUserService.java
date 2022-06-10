package com.aladdin.mis.engineering.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectBugUser;
/**
 * ProjectBugUserService
 * @author cles
 * @date 2022-06-07T00:17:46.097
*/
public interface ProjectBugUserService extends GlobalService<ProjectBugUser>  {

    /**
     * 保存缺陷管理人员
     * @param entity
     * @return
     */
    boolean save(ProjectBugUser entity);

    /**
     * 修改状态
     * @param entity
     * @return
     */
    boolean update(ProjectBugUser entity);
}
