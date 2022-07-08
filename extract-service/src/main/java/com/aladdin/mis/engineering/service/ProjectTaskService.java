package com.aladdin.mis.engineering.service;

import com.aladdin.mis.common.system.service.GlobalService;
import com.aladdin.mis.engineering.entity.ProjectTask;

/**
 * ProjectTaskService
 * @author cles
 * @date 2022-07-05 21:58:00
*/
public interface ProjectTaskService extends GlobalService<ProjectTask>  {


    /**
     * 保存任务
     * @param entity
     * @return
     */
    boolean save(ProjectTask entity);

    /**
     * 删除任务
     * @param data
     * @return
     */
    boolean deleteTask(ProjectTask data);
}
