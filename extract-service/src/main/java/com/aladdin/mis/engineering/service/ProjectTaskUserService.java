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
     * 挂起任务
     *
     * @param id
     * @return
     */
    boolean hangTask(Integer id);

    /**
     * 继续任务
     * @param id
     * @return
     */
    boolean continueTask(Integer id);

}
