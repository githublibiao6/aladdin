package com.aladdin.mis.engineering.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectTaskUser;
/**
 * ProjectTaskUserService
 * @author cles
 * @date 2022-07-05 21:57:55
*/
public interface ProjectTaskUserService extends GlobalService<ProjectTaskUser>  {

    /**
     * 保存
     * @param entity
     * @return
     */
    boolean save(ProjectTaskUser entity);

    /**
     * 删除任务人员
     * @param id
     * @return
     */
    boolean deleteUser(Integer id);

}
